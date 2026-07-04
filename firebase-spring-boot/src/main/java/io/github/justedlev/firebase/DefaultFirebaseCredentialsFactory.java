package io.github.justedlev.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;

import java.io.IOException;

public record DefaultFirebaseCredentialsFactory(ResourceLoader resourceLoader) implements FirebaseCredentialsFactory {
    @Override
    public GoogleCredentials create(FirebaseProperties properties) {
        if (!StringUtils.hasText(properties.getCredentials())) {
            try {
                return GoogleCredentials.getApplicationDefault();
            } catch (IOException e) {
                throw new IllegalStateException("Failed to load application default Google credentials", e);
            }
        }
        var resource = resourceLoader.getResource(properties.getCredentials());
        try (var in = resource.getInputStream()) {
            return GoogleCredentials.fromStream(in);
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load Google credentials from '" + properties.getCredentials() + "'", e);
        }
    }
}
