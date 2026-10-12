package io.github.justedlev.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;

import java.time.Duration;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultFirebaseOptionsFactoryTest {
    private final GoogleCredentials credentials = GoogleCredentials.newBuilder().build();
    private final DefaultFirebaseOptionsFactory factory = new DefaultFirebaseOptionsFactory(props -> credentials);

    @Test
    void mapsAllProperties() {
        var props = FirebaseProperties.builder()
                .projectId("project")
                .serviceAccountId("sa@project.iam.gserviceaccount.com")
                .databaseAuthVariableOverride(Map.of("uid", "service"))
                .db(FirebaseDatabaseProperties.builder().url("https://project.firebaseio.com").build())
                .storage(StorageProperties.builder().bucket("project.appspot.com").build())
                .connectTimeout(Duration.ofSeconds(1))
                .readTimeout(Duration.ofSeconds(2))
                .writeTimeout(Duration.ofSeconds(3))
                .build();

        var options = factory.create(props);

        assertThat(options.getProjectId()).isEqualTo("project");
        assertThat(options.getServiceAccountId()).isEqualTo("sa@project.iam.gserviceaccount.com");
        assertThat(options.getDatabaseAuthVariableOverride()).containsEntry("uid", "service");
        assertThat(options.getDatabaseUrl()).isEqualTo("https://project.firebaseio.com");
        assertThat(options.getStorageBucket()).isEqualTo("project.appspot.com");
        assertThat(options.getConnectTimeout()).isEqualTo(1000);
        assertThat(options.getReadTimeout()).isEqualTo(2000);
        assertThat(options.getWriteTimeout()).isEqualTo(3000);
    }

    @Test
    void unsetPropertiesKeepSdkDefaults() {
        var options = factory.create(new FirebaseProperties());

        assertThat(options.getProjectId()).isNull();
        assertThat(options.getDatabaseUrl()).isNull();
        assertThat(options.getStorageBucket()).isNull();
        assertThat(options.getConnectTimeout()).isZero();
        assertThat(options.getReadTimeout()).isZero();
    }

    @Test
    void timeoutsBindFromDurationsAndPlainMillis() {
        var source = new MapConfigurationPropertySource(Map.of(
                "app.connect-timeout", "5s",
                "app.read-timeout", "1500"
        ));

        var props = new Binder(source).bind("app", FirebaseProperties.class).get();

        assertThat(props.getConnectTimeout()).isEqualTo(Duration.ofSeconds(5));
        assertThat(props.getReadTimeout()).isEqualTo(Duration.ofMillis(1500));
    }
}
