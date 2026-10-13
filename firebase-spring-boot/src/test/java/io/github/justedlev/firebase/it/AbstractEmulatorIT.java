package io.github.justedlev.firebase.it;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Base class for tests run by the {@code it} Maven profile inside {@code firebase emulators:exec},
 * which exports the emulator host variables the Firebase Admin SDK reads.
 */
@SpringBootTest(classes = EmulatorIntegrationTestApplication.class)
@ActiveProfiles("it")
abstract class AbstractEmulatorIT {
    private static final List<String> EMULATOR_HOST_VARS = List.of(
            "FIREBASE_AUTH_EMULATOR_HOST",
            "FIREBASE_DATABASE_EMULATOR_HOST",
            "FIRESTORE_EMULATOR_HOST"
    );

    @BeforeAll
    static void requireEmulators() {
        // Fail fast instead of talking to production Firebase when run outside emulators:exec
        EMULATOR_HOST_VARS.forEach(name -> assertNotNull(System.getenv(name),
                name + " is not set; run the tests via 'firebase emulators:exec' (see CONTRIBUTING.md)"));
    }
}
