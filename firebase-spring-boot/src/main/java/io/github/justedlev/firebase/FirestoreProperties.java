package io.github.justedlev.firebase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FirestoreProperties {
    /**
     * Whether to register a {@code Firestore} bean.
     */
    private boolean enabled;
}
