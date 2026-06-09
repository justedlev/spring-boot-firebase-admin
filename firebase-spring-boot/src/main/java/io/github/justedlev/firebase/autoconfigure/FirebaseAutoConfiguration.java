package io.github.justedlev.firebase.autoconfigure;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
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
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;

import static io.github.justedlev.firebase.config.FirebaseConfigurationProperties.PREFIX;

@AutoConfiguration
@ConditionalOnProperty(prefix = PREFIX, value = "enabled", havingValue = "true", matchIfMissing = true)
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
    @ConditionalOnProperty(prefix = PREFIX + ".apps.default.db", value = "enabled", havingValue = "true", matchIfMissing = true)
    @ConditionalOnExpression("T(org.springframework.util.StringUtils).hasText('${firebase.apps.default.db.url:}')")
    public FirebaseDatabase defaultFirebaseDatabase(FirebaseApp firebaseApp) {
        return FirebaseDatabase.getInstance(firebaseApp);
    }

    @Bean
    @ConditionalOnBean(name = "defaultFirebaseApp")
    @ConditionalOnProperty(prefix = PREFIX + ".apps.default.auth", havingValue = "true", value = "enabled")
    public FirebaseAuth defaultFirebaseAuth(FirebaseApp firebaseApp) {
        return FirebaseAuth.getInstance(firebaseApp);
    }

    @Bean
    @ConditionalOnBean(name = "defaultFirebaseApp")
    @ConditionalOnProperty(prefix = PREFIX + ".apps.default.messaging", havingValue = "true", value = "enabled")
    public FirebaseMessaging defaultFirebaseMessaging(FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }

    @Bean
    @ConditionalOnBean(name = "defaultFirebaseApp")
    @ConditionalOnProperty(prefix = PREFIX + ".apps.default.storage", havingValue = "true", value = "enabled", matchIfMissing = true)
    @ConditionalOnExpression("T(org.springframework.util.StringUtils).hasText('${firebase.apps.default.storage.bucket:}')")
    public StorageClient defaultStorageClient(FirebaseApp firebaseApp) {
        return StorageClient.getInstance(firebaseApp);
    }

    @Bean
    @ConditionalOnBean(name = "defaultFirebaseApp")
    @ConditionalOnProperty(prefix = PREFIX + ".apps.default.firestore", havingValue = "true", value = "enabled")
    public Firestore defaultFirestore(FirebaseApp firebaseApp) {
        return FirestoreClient.getFirestore(firebaseApp);
    }
}
