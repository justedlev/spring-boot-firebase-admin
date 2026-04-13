package io.github.justedlev.firebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import io.github.justedlev.firebase.FirebaseCredentialsFactory;
import io.github.justedlev.firebase.FirebaseProperties;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration(proxyBeanMethods = false)
public class FirebaseTestConfiguration {
    @Bean
    public FirebaseCredentialsFactory mockFirebaseCredentialsFactory() {
        var mock = Mockito.mock(FirebaseCredentialsFactory.class);
        Mockito.when(mock.create(Mockito.any(FirebaseProperties.class)))
                .thenReturn(GoogleCredentials.newBuilder().build());

        return mock;
    }
}
