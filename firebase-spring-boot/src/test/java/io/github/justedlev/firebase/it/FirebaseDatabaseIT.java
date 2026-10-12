package io.github.justedlev.firebase.it;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

class FirebaseDatabaseIT extends AbstractEmulatorIT {
    @Autowired
    private FirebaseDatabase firebaseDatabase;

    @Test
    void writesAndReadsValue() throws Exception {
        var ref = firebaseDatabase.getReference("it/" + UUID.randomUUID());

        ref.setValueAsync("hello").get(10, TimeUnit.SECONDS);

        assertThat(read(ref)).isEqualTo("hello");
        ref.removeValueAsync().get(10, TimeUnit.SECONDS);
    }

    private static Object read(DatabaseReference ref) throws Exception {
        var result = new CompletableFuture<>();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                result.complete(snapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                result.completeExceptionally(error.toException());
            }
        });
        return result.get(10, TimeUnit.SECONDS);
    }
}
