package io.github.justedlev.firebase;

import com.google.firebase.FirebaseOptions;

/**
 * Strategy interface for constructing {@link FirebaseOptions} for a Firebase application.
 * <p>
 * Implementations receive an already created {@link com.google.auth.oauth2.GoogleCredentials} instance
 * and a {@link FirebaseProperties} object and are expected to assemble a complete
 * {@link FirebaseOptions} descriptor, suitable for initializing a {@link com.google.firebase.FirebaseApp}.
 *
 * <p>This abstraction allows:
 * <ul>
 *     <li>customizing initialization of Firebase services</li>
 *     <li>deriving {@code projectId} and other settings from properties or credentials</li>
 *     <li>supporting multiple Firebase applications in the same Spring context</li>
 *     <li>extending default behavior without overriding the entire autoconfiguration</li>
 * </ul>
 *
 * <p>Implementations should:
 * <ul>
 *     <li>ensure that all mandatory fields (such as projectId) are resolved</li>
 *     <li>throw descriptive exceptions when configuration is invalid</li>
 *     <li>avoid direct initialization of {@link com.google.firebase.FirebaseApp}</li>
 * </ul>
 *
 * <p>Expected usage:
 * <pre>{@code
 * FirebaseOptions options = firebaseOptionsFactory.create(appProperties);
 * FirebaseApp.initializeApp(options, "appName");
 * }</pre>
 *
 * @author Edward L.
 */
public interface FirebaseOptionsFactory {
    /**
     * Create {@link FirebaseOptions} from the given Firebase application properties.
     *
     * @param properties configuration properties of a single Firebase application
     *                   (never {@code null})
     * @return a fully built {@link FirebaseOptions} instance
     */
    FirebaseOptions create(FirebaseProperties properties);
}
