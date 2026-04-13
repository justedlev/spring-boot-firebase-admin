package io.github.justedlev.firebase.autoconfigure;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import io.github.justedlev.firebase.DefaultFirebaseCredentialsFactory;
import io.github.justedlev.firebase.DefaultFirebaseOptionsFactory;
import io.github.justedlev.firebase.FirebaseCredentialsFactory;
import io.github.justedlev.firebase.FirebaseOptionsFactory;
import io.github.justedlev.firebase.config.FirebaseAppsBeanDefinitionRegistryPostProcessor;
import io.github.justedlev.firebase.config.FirebaseConfigurationProperties;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;

@AutoConfiguration
@ConditionalOnBooleanProperty(prefix = FirebaseConfigurationProperties.PREFIX, value = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(FirebaseConfigurationProperties.class)
public class FirebaseAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public FirebaseCredentialsFactory defaultFirebaseCredentialsFactory(ResourceLoader resourceLoader) {
        return new DefaultFirebaseCredentialsFactory(resourceLoader);
    }

    @Bean
    @ConditionalOnMissingBean
    public FirebaseOptionsFactory defaultFirebaseOptionsFactory(FirebaseCredentialsFactory credentialsFactory) {
        return new DefaultFirebaseOptionsFactory(credentialsFactory);
    }

    @Bean
    @ConditionalOnFirebaseAppsProperties
    public static BeanDefinitionRegistryPostProcessor firebaseAppsPostProcessor(FirebaseOptionsFactory optionsFactory) {
        return new FirebaseAppsBeanDefinitionRegistryPostProcessor(optionsFactory);
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean
    public FirebaseApp defaultFirebaseApp(FirebaseOptionsFactory optionsFactory, FirebaseConfigurationProperties properties) {
        var props = properties.getDefaultApp();
        var options = optionsFactory.create(props);
        return FirebaseApp.initializeApp(options, props.getName());
    }

    @Bean
    @ConditionalOnBean(name = "defaultFirebaseApp")
    public FirebaseDatabase defaultFirebaseDatabase(FirebaseApp firebaseApp) {
        return FirebaseDatabase.getInstance(firebaseApp);
    }

    @Bean
    @ConditionalOnBean(name = "defaultFirebaseApp")
    public FirebaseAuth defaultFirebaseAuth(FirebaseApp firebaseApp) {
        return FirebaseAuth.getInstance(firebaseApp);
    }

    @Bean
    @ConditionalOnBean(name = "defaultFirebaseApp")
    public FirebaseMessaging defaultFirebaseMessaging(FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }
}
