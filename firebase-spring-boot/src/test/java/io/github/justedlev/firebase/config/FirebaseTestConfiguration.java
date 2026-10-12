package io.github.justedlev.firebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import io.github.justedlev.firebase.FirebaseCredentialsFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration(proxyBeanMethods = false)
public class FirebaseTestConfiguration {
    @Bean
    public FirebaseCredentialsFactory mockFirebaseCredentialsFactory() {
        return properties -> GoogleCredentials.newBuilder().build();
    }
}
