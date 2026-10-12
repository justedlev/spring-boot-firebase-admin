package io.github.justedlev.firebase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageProperties {
    /**
     * Whether to register a {@code StorageClient} bean. Only takes effect when {@code bucket} is set.
     */
    @Builder.Default
    private boolean enabled = true;
    /**
     * The default Cloud Storage bucket name, without the {@code gs://} prefix.
     */
    private String bucket;
}
