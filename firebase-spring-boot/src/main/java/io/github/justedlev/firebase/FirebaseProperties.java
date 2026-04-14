package io.github.justedlev.firebase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static com.google.firebase.FirebaseApp.DEFAULT_APP_NAME;

/**
 * Configuration properties for Firebase services.
 * This is a pure Java POJO without Spring dependencies.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FirebaseProperties {
    @lombok.Builder.Default
    private String name = DEFAULT_APP_NAME;
    @lombok.Builder.Default
    private Map<String, Object> databaseAuthVariableOverride = new HashMap<>();
    private String databaseUrl;
    private String projectId;
    private String storageBucket;
    private String serviceAccountId;
    private String credentials;
    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;
    private FirebaseAuthProperties auth = new FirebaseAuthProperties();
    private FirebaseDatabaseProperties db = new FirebaseDatabaseProperties();
}
