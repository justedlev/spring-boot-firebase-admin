package io.github.justedlev.firebase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FirebaseDatabaseProperties {
    /**
     * Whether to register a {@code FirebaseDatabase} bean. Only takes effect when {@code url} is set.
     */
    @Builder.Default
    private boolean enabled = true;
    /**
     * The Realtime Database URL, e.g. {@code https://<project-id>-default-rtdb.firebaseio.com}.
     */
    private String url;
}
