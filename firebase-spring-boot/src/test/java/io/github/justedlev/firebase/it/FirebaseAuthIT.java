package io.github.justedlev.firebase.it;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class FirebaseAuthIT extends AbstractEmulatorIT {
    @Autowired
    private FirebaseAuth firebaseAuth;

    @Autowired
    @Qualifier("secondaryFirebaseAuth")
    private FirebaseAuth secondaryFirebaseAuth;

    @Test
    void createsAndReadsUser() throws Exception {
        var email = UUID.randomUUID() + "@example.com";

        var created = firebaseAuth.createUser(new UserRecord.CreateRequest().setEmail(email).setPassword("secret123"));

        assertThat(firebaseAuth.getUserByEmail(email).getUid()).isEqualTo(created.getUid());
        firebaseAuth.deleteUser(created.getUid());
    }

    @Test
    void createsCustomToken() throws Exception {
        assertThat(firebaseAuth.createCustomToken("some-uid")).isNotBlank();
    }

    @Test
    void namedAppUsesItsOwnFirebaseApp() throws Exception {
        assertThat(secondaryFirebaseAuth).isNotSameAs(firebaseAuth);
        var created = secondaryFirebaseAuth.createUser(new UserRecord.CreateRequest().setUid("secondary-" + UUID.randomUUID()));

        assertThat(secondaryFirebaseAuth.getUser(created.getUid()).getUid()).isEqualTo(created.getUid());
        secondaryFirebaseAuth.deleteUser(created.getUid());
    }
}
