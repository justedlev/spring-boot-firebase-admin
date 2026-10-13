package io.github.justedlev.firebase.it;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import io.github.justedlev.firebase.FirebaseCredentialsFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Minimal application for integration tests against the Firebase Emulator Suite.
 * <p>
 * The emulators accept the {@code owner} token as an admin, which bypasses security rules.
 */
@SpringBootConfiguration
@EnableAutoConfiguration
class EmulatorIntegrationTestApplication {
    @Bean
    FirebaseCredentialsFactory emulatorCredentialsFactory() {
        return properties -> GoogleCredentials.create(new AccessToken("owner", Date.from(Instant.now().plus(Duration.ofDays(1)))));
    }
}
