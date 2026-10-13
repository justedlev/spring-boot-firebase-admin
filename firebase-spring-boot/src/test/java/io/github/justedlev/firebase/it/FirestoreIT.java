package io.github.justedlev.firebase.it;

import com.google.cloud.firestore.Firestore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class FirestoreIT extends AbstractEmulatorIT {
    @Autowired
    private Firestore firestore;

    @Autowired
    @Qualifier("secondaryFirestore")
    private Firestore secondaryFirestore;

    @Test
    void writesAndReadsDocument() throws Exception {
        var doc = firestore.collection("it").document(UUID.randomUUID().toString());

        doc.set(Map.of("greeting", "hello")).get(10, TimeUnit.SECONDS);

        assertThat(doc.get().get(10, TimeUnit.SECONDS).getString("greeting")).isEqualTo("hello");
        doc.delete().get(10, TimeUnit.SECONDS);
    }

    @Test
    void namedAppFirestoreWorks() throws Exception {
        assertThat(secondaryFirestore).isNotSameAs(firestore);
        var doc = secondaryFirestore.collection("it").document(UUID.randomUUID().toString());

        doc.set(Map.of("app", "secondary")).get(10, TimeUnit.SECONDS);

        assertThat(doc.get().get(10, TimeUnit.SECONDS).getString("app")).isEqualTo("secondary");
        doc.delete().get(10, TimeUnit.SECONDS);
    }
}
