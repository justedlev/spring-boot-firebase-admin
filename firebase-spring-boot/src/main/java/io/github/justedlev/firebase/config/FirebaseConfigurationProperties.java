package io.github.justedlev.firebase.config;

import io.github.justedlev.firebase.FirebaseProperties;
import lombok.Data;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.Map;

/**
 * Base configuration properties class to configure the firebase app
 */
@Data
@ConfigurationProperties(FirebaseConfigurationProperties.PREFIX)
public class FirebaseConfigurationProperties {
    public static final String PREFIX = "firebase";
    public static final String DEFAULT_APP_NAME = "default";

    /**
     * Flag to enable or disable firebase initialization
     */
    private boolean enabled = true;
    /**
     * Firebase apps properties
     */
    private Map<String, FirebaseProperties> apps = Collections.emptyMap();

    @NonNull
    public FirebaseProperties getDefaultApp() {
        return apps.get(DEFAULT_APP_NAME);
    }

    public FirebaseConfigurationProperties setDefaultApp(FirebaseProperties properties) {
        apps.put(DEFAULT_APP_NAME, properties);
        return this;
    }
}
