package io.github.justedlev.firebase.config;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import io.github.justedlev.firebase.FirebaseOptionsFactory;
import io.github.justedlev.firebase.FirebaseProperties;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static io.github.justedlev.firebase.config.FirebaseConfigurationProperties.DEFAULT_APP_NAME;

/**
 * Registers a {@link FirebaseApp} bean named {@code <key>FirebaseApp} for every entry under
 * {@code firebase.apps}, except {@code default}, along with its enabled service beans:
 * {@code <key>FirebaseAuth}, {@code <key>FirebaseDatabase}, {@code <key>FirebaseMessaging},
 * {@code <key>StorageClient} and {@code <key>Firestore}.
 * <p>
 * The {@link FirebaseOptionsFactory} is looked up only when an app bean is created, so the
 * factory (and anything it depends on) is still a regular bean, processed by all
 * {@link org.springframework.beans.factory.config.BeanPostProcessor BeanPostProcessors}.
 */
public class FirebaseAppsBeanDefinitionRegistryPostProcessor
        implements BeanDefinitionRegistryPostProcessor, EnvironmentAware, BeanFactoryAware {
    private static final String BEAN_NAME_SUFFIX = FirebaseApp.class.getSimpleName();
    private FirebaseConfigurationProperties properties;
    private BeanFactory beanFactory;

    @Override
    public void setEnvironment(@NonNull Environment environment) {
        properties = Binder.get(environment)
                .bind(FirebaseConfigurationProperties.PREFIX, FirebaseConfigurationProperties.class)
                .orElseGet(FirebaseConfigurationProperties::new);
    }

    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(@NonNull BeanDefinitionRegistry registry) throws BeansException {
        properties.getApps()
                .entrySet()
                .stream()
                .filter(Predicate.not(entry -> DEFAULT_APP_NAME.equals(entry.getKey())))
                .forEach(entry -> registerApp(registry, entry.getKey(), entry.getValue()));
    }

    private void registerApp(BeanDefinitionRegistry registry, String appKey, FirebaseProperties props) {
        var appBeanName = appKey + BEAN_NAME_SUFFIX;
        var appDefinition = BeanDefinitionBuilder.genericBeanDefinition(
                FirebaseApp.class,
                firebaseAppSupplier(appKey, props)
        ).setDestroyMethodName("delete").getBeanDefinition();
        registry.registerBeanDefinition(appBeanName, appDefinition);

        if (props.getAuth().isEnabled()) {
            registerService(registry, appKey, appBeanName, FirebaseAuth.class, FirebaseAuth::getInstance);
        }
        if (props.getDb().isEnabled() && StringUtils.hasText(props.getDb().getUrl())) {
            registerService(registry, appKey, appBeanName, FirebaseDatabase.class, FirebaseDatabase::getInstance);
        }
        if (props.getMessaging().isEnabled()) {
            registerService(registry, appKey, appBeanName, FirebaseMessaging.class, FirebaseMessaging::getInstance);
        }
        if (props.getStorage().isEnabled() && StringUtils.hasText(props.getStorage().getBucket())) {
            registerService(registry, appKey, appBeanName, StorageClient.class, StorageClient::getInstance);
        }
        if (props.getFirestore().isEnabled()) {
            registerService(registry, appKey, appBeanName, Firestore.class, FirestoreClient::getFirestore);
        }
    }

    private <T> void registerService(BeanDefinitionRegistry registry, String appKey, String appBeanName,
                                     Class<T> type, Function<FirebaseApp, T> factory) {
        var definition = BeanDefinitionBuilder.genericBeanDefinition(
                type,
                () -> factory.apply(beanFactory.getBean(appBeanName, FirebaseApp.class))
        ).addDependsOn(appBeanName).getBeanDefinition();
        registry.registerBeanDefinition(appKey + type.getSimpleName(), definition);
    }

    private Supplier<FirebaseApp> firebaseAppSupplier(String appKey, FirebaseProperties props) {
        // Fall back to the map key as the Firebase app name when the user did not set an
        // explicit name; otherwise every unnamed app would inherit FirebaseApp.DEFAULT_APP_NAME
        // and collide on FirebaseApp.initializeApp.
        var name = FirebaseApp.DEFAULT_APP_NAME.equals(props.getName()) ? appKey : props.getName();
        return () -> {
            var optionsFactory = beanFactory.getBean(FirebaseOptionsFactory.class);
            return FirebaseApp.initializeApp(optionsFactory.create(props), name);
        };
    }
}
