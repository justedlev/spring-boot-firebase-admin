package io.github.justedlev.firebase.config;

import com.google.firebase.FirebaseApp;
import io.github.justedlev.firebase.FirebaseOptionsFactory;
import io.github.justedlev.firebase.FirebaseProperties;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static io.github.justedlev.firebase.config.FirebaseConfigurationProperties.DEFAULT_APP_NAME;

@Setter
@RequiredArgsConstructor
public class FirebaseAppsBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {
    private static final String BEAN_NAME_SUFFIX = FirebaseApp.class.getSimpleName();
    private final FirebaseOptionsFactory optionsFactory;
    private FirebaseConfigurationProperties properties;

    @Override
    public void setEnvironment(@NonNull Environment environment) {
        var binder = Binder.get(environment);
        var result = binder.bind(
                FirebaseConfigurationProperties.PREFIX,
                FirebaseConfigurationProperties.class
        );
        setProperties(result.get());
    }

    @Override
    public void postProcessBeanDefinitionRegistry(@NonNull BeanDefinitionRegistry registry) throws BeansException {
        properties.getApps()
                .entrySet()
                .stream()
                .filter(Predicate.not(entry -> DEFAULT_APP_NAME.equals(entry.getKey())))
                .forEach(entry -> {
                    var beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(
                            FirebaseApp.class,
                            firebaseAppSupplier(entry.getValue())
                    ).getBeanDefinition();
                    registry.registerBeanDefinition(
                            entry.getKey() + BEAN_NAME_SUFFIX,
                            beanDefinition
                    );
                });
    }

    private Supplier<FirebaseApp> firebaseAppSupplier(FirebaseProperties props) {
        return () -> FirebaseApp.initializeApp(optionsFactory.create(props), props.getName());
    }
}
