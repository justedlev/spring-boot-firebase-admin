package io.github.justedlev.firebase;

import com.google.auth.oauth2.GoogleCredentials;

/**
 * Strategy interface for creating {@link GoogleCredentials} for a Firebase application.
 * <p>
 * Implementations of this interface are responsible for producing a fully
 * configured instance of {@link GoogleCredentials} based on the provided
 * {@link FirebaseProperties}. This allows customizing how credentials are loaded,
 * resolved and validated inside a Spring Boot starter or runtime system.
 *
 * <p>Typical implementations load credentials from:
 * <ul>
 *     <li>the location pointed by {@code firebase.apps.*.credentials}</li>
 *     <li>environment-dependent sources</li>
 *     <li>alternative credential providers (GCP metadata server, Vault, etc.)</li>
 * </ul>
 *
 * <p>Implementations should:
 * <ul>
 *     <li>validate that required properties are present and meaningful</li>
 *     <li>throw an appropriate exception if credentials cannot be created</li>
 *     <li>remain side-effect-free (do not register or mutate global Firebase state)</li>
 * </ul>
 *
 * <p>Expected usage:
 * <pre>{@code
 * GoogleCredentials credentials = credentialsFactory.create(appProperties);
 * }</pre>
 *
 * @author Edward L.
 */
public interface FirebaseCredentialsFactory {
    /**
     * Create {@link GoogleCredentials} for the given Firebase application.
     *
     * @param properties configuration properties of a single Firebase application
     *                   (never {@code null})
     * @return a fully initialized {@link GoogleCredentials} instance
     */
    GoogleCredentials create(FirebaseProperties properties);
}
