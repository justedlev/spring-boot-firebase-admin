package io.github.justedlev.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import lombok.SneakyThrows;
import org.springframework.core.io.ResourceLoader;

public record DefaultFirebaseCredentialsFactory(ResourceLoader resourceLoader) implements FirebaseCredentialsFactory {
    @SneakyThrows
    @Override
    public GoogleCredentials create(FirebaseProperties properties) {
        var resource = resourceLoader.getResource(properties.getCredentials());
        var in = resource.getInputStream();
        return GoogleCredentials.fromStream(in);
    }
}
