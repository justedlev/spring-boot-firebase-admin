package io.github.justedlev.firebase;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import io.github.justedlev.firebase.autoconfigure.FirebaseAutoConfiguration;
import io.github.justedlev.firebase.config.FirebaseConfigurationProperties;
import io.github.justedlev.firebase.config.FirebaseTestConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class FirebaseAutoConfigurationTest {
    @AfterEach
    void afterEach() {
        FirebaseApp.getApps().forEach(FirebaseApp::delete);
    }

    @Test
    void withEnabled_defaultFirebaseApp() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.enabled=true",
                        "firebase.apps.default.project-id=default-project",
                        "firebase.apps.default.database-url=http://localhost:0"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(FirebaseApp.class);
                    assertThat(context).hasSingleBean(FirebaseAuth.class);
                    assertThat(context).hasSingleBean(FirebaseDatabase.class);
                    assertThat(context).hasSingleBean(FirebaseConfigurationProperties.class);
                });
    }

    @Test
    void withEnabled_multiFirebaseApp() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.enabled=true",
                        "firebase.apps.default.project-id=default-project",
                        "firebase.apps.default.database-url=http://localhost:0",
                        "firebase.apps.app1.name=app1",
                        "firebase.apps.app1.project-id=app1-project",
                        "firebase.apps.app1.database-url=http://localhost:0",
                        "firebase.apps.app2.name=app2",
                        "firebase.apps.app2.project-id=app2-project",
                        "firebase.apps.app2.database-url=http://localhost:0"
                )
                .run(context -> {
                    assertThat(context).hasBean("defaultFirebaseApp");
                    assertThat(context).hasBean("app1FirebaseApp");
                    assertThat(context).hasBean("app2FirebaseApp");
                });
    }

    @Test
    void whenDisabled_thenNoBeansCreated() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withPropertyValues("firebase.enabled=false")
                .run(ctx -> {
                    assertThat(ctx).doesNotHaveBean(FirebaseConfigurationProperties.class);
                    assertThat(ctx).doesNotHaveBean(FirebaseApp.class);
                    assertThat(ctx).doesNotHaveBean(FirebaseAuth.class);
                    assertThat(ctx).doesNotHaveBean(FirebaseDatabase.class);
                });
    }
}
