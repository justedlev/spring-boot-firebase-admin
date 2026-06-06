package io.github.justedlev.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import lombok.SneakyThrows;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;

public record DefaultFirebaseCredentialsFactory(ResourceLoader resourceLoader) implements FirebaseCredentialsFactory {
    @SneakyThrows
    @Override
    public GoogleCredentials create(FirebaseProperties properties) {
        if (!StringUtils.hasText(properties.getCredentials())) {
            return GoogleCredentials.getApplicationDefault();
        }
        var resource = resourceLoader.getResource(properties.getCredentials());
        var in = resource.getInputStream();
        return GoogleCredentials.fromStream(in);
    }
}
