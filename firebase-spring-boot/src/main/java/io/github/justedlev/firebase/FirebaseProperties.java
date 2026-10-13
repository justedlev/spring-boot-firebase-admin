package io.github.justedlev.firebase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
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
    /**
     * Firebase app name. Named apps fall back to their {@code firebase.apps} key when not set.
     */
    @lombok.Builder.Default
    private String name = DEFAULT_APP_NAME;
    /**
     * Value of the {@code auth} variable in Realtime Database security rules.
     */
    private Map<String, Object> databaseAuthVariableOverride;
    /**
     * Google Cloud project ID.
     */
    private String projectId;
    /**
     * Service account email used to sign custom tokens.
     */
    private String serviceAccountId;
    /**
     * Location of a credentials JSON file, e.g. {@code classpath:firebase.json} or
     * {@code file:/etc/firebase.json}. Application Default Credentials are used when not set.
     */
    private String credentials;
    /**
     * Connect timeout for outgoing HTTP connections. Plain numbers are interpreted as milliseconds.
     */
    private Duration connectTimeout;
    /**
     * Read timeout for outgoing HTTP connections. Plain numbers are interpreted as milliseconds.
     */
    private Duration readTimeout;
    /**
     * Write timeout for outgoing HTTP connections. Plain numbers are interpreted as milliseconds.
     */
    private Duration writeTimeout;
    /**
     * Firebase Authentication settings.
     */
    @lombok.Builder.Default
    private FirebaseAuthProperties auth = new FirebaseAuthProperties();
    /**
     * Realtime Database settings.
     */
    @lombok.Builder.Default
    private FirebaseDatabaseProperties db = new FirebaseDatabaseProperties();
    /**
     * Cloud Messaging settings.
     */
    @lombok.Builder.Default
    private FirebaseMessagingProperties messaging = new FirebaseMessagingProperties();
    /**
     * Cloud Storage settings.
     */
    @lombok.Builder.Default
    private StorageProperties storage = new StorageProperties();
    /**
     * Cloud Firestore settings.
     */
    @lombok.Builder.Default
    private FirestoreProperties firestore = new FirestoreProperties();
}
