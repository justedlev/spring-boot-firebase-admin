package io.github.justedlev.firebase;

import io.github.justedlev.firebase.autoconfigure.FirebaseAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.annotation.ImportCandidates;

import static org.assertj.core.api.Assertions.assertThat;

class AutoConfigurationRegistrationTest {
    @Test
    void firebaseAutoConfigurationIsDiscoverable() {
        var candidates = ImportCandidates.load(AutoConfiguration.class, getClass().getClassLoader());

        assertThat(candidates).contains(FirebaseAutoConfiguration.class.getName());
    }
}
