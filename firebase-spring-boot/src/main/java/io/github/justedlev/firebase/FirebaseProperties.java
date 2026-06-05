package io.github.justedlev.firebase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Map<String, Object> databaseAuthVariableOverride;
    private String projectId;
    private String serviceAccountId;
    private String credentials;
    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;
    @lombok.Builder.Default
    private FirebaseAuthProperties auth = new FirebaseAuthProperties();
    @lombok.Builder.Default
    private FirebaseDatabaseProperties db = new FirebaseDatabaseProperties();
    @lombok.Builder.Default
    private FirebaseMessagingProperties messaging = new FirebaseMessagingProperties();
    @lombok.Builder.Default
    private StorageProperties storage = new StorageProperties();
    @lombok.Builder.Default
    private FirestoreProperties firestore = new FirestoreProperties();
}
