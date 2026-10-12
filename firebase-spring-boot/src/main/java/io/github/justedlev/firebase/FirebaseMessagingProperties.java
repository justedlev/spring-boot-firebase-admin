package io.github.justedlev.firebase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FirebaseMessagingProperties {
    /**
     * Whether to register a {@code FirebaseMessaging} bean.
     */
    private boolean enabled;
}
