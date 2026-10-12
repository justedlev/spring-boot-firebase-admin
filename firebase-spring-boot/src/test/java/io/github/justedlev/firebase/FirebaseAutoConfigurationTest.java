package io.github.justedlev.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import io.github.justedlev.firebase.autoconfigure.FirebaseAutoConfiguration;
import io.github.justedlev.firebase.config.FirebaseConfigurationProperties;
import io.github.justedlev.firebase.config.FirebaseTestConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

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
                        "firebase.apps.default.project-id=default-project"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(FirebaseApp.class);
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
                        "firebase.apps.app1.name=app1",
                        "firebase.apps.app1.project-id=app1-project",
                        "firebase.apps.app2.name=app2",
                        "firebase.apps.app2.project-id=app2-project"
                )
                .run(context -> {
                    assertThat(context).hasBean("defaultFirebaseApp");
                    assertThat(context).hasBean("app1FirebaseApp");
                    assertThat(context).hasBean("app2FirebaseApp");
                });
    }

    @Test
    void whenNoDefaultApp_thenOnlyNamedAppsCreated() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.enabled=true",
                        "firebase.apps.app1.name=app1",
                        "firebase.apps.app1.project-id=app1-project"
                )
                .run(context -> {
                    assertThat(context).hasNotFailed();
                    assertThat(context).doesNotHaveBean("defaultFirebaseApp");
                    assertThat(context).hasBean("app1FirebaseApp");
                });
    }

    @Test
    void withEnabled_multiFirebaseApp_withoutExplicitName() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.enabled=true",
                        "firebase.apps.default.project-id=default-project",
                        "firebase.apps.app1.project-id=app1-project",
                        "firebase.apps.app2.project-id=app2-project"
                )
                .run(context -> {
                    assertThat(context).hasNotFailed();
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
                });
    }

    @Test
    void whenAllEnabled_thenBeansCreated() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.enabled=true",
                        "firebase.apps.default.project-id=default-project",
                        "firebase.apps.default.db.url=http://localhost:0",
                        "firebase.apps.default.auth.enabled=true",
                        "firebase.apps.default.messaging.enabled=true",
                        "firebase.apps.default.storage.bucket=default-bucket",
                        "firebase.apps.default.firestore.enabled=true"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(FirebaseApp.class);
                    assertThat(context).hasSingleBean(FirebaseDatabase.class);
                    assertThat(context).hasSingleBean(FirebaseAuth.class);
                    assertThat(context).hasSingleBean(FirebaseMessaging.class);
                    assertThat(context).hasSingleBean(StorageClient.class);
                    assertThat(context).hasSingleBean(Firestore.class);
                });
    }

    @Test
    void whenAuthEnabled_thenFirebaseAuthBeanCreated() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.enabled=true",
                        "firebase.apps.default.project-id=default-project",
                        "firebase.apps.default.auth.enabled=true"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(FirebaseApp.class);
                    assertThat(context).hasSingleBean(FirebaseAuth.class);
                });
    }

    @Test
    void whenMessagingEnabled_thenFirebaseMessagingBeanCreated() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.enabled=true",
                        "firebase.apps.default.project-id=default-project",
                        "firebase.apps.default.messaging.enabled=true"
                )
                .run(context -> {
                    assertThat(context).hasSingleBean(FirebaseApp.class);
                    assertThat(context).hasSingleBean(FirebaseMessaging.class);
                });
    }

    @Test
    void whenContextClosed_thenFirebaseAppsDeleted() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.apps.default.project-id=default-project",
                        "firebase.apps.app1.project-id=app1-project"
                )
                .run(context -> assertThat(FirebaseApp.getApps()).hasSize(2));

        assertThat(FirebaseApp.getApps()).isEmpty();
    }

    @Test
    void whenContextRestarted_thenFirebaseAppsReinitialized() {
        var runner = new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues("firebase.apps.default.project-id=default-project");

        runner.run(context -> assertThat(context).hasNotFailed());
        runner.run(context -> assertThat(context).hasNotFailed());
    }

    @Test
    void whenNamedAppsConfigured_thenFactoriesAreNotInitializedEarly() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class, RecordingPostProcessorConfiguration.class)
                .withPropertyValues("firebase.apps.app1.project-id=app1-project")
                .run(context -> {
                    assertThat(context).hasNotFailed();
                    assertThat(context.getBean(RecordingPostProcessor.class).processed)
                            .contains("defaultFirebaseOptionsFactory", "mockFirebaseCredentialsFactory");
                });
    }

    @Configuration(proxyBeanMethods = false)
    static class RecordingPostProcessorConfiguration {
        @Bean
        static RecordingPostProcessor recordingPostProcessor() {
            return new RecordingPostProcessor();
        }
    }

    static class RecordingPostProcessor implements BeanPostProcessor {
        private final Set<String> processed = new HashSet<>();

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) {
            processed.add(beanName);
            return bean;
        }
    }

    @Test
    void whenUserDefinesOwnFirebaseApp_thenServiceBeansUseIt() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(CustomFirebaseAppConfiguration.class)
                .withPropertyValues("firebase.apps.default.auth.enabled=true")
                .run(context -> {
                    assertThat(context).hasNotFailed();
                    assertThat(context).hasSingleBean(FirebaseApp.class);
                    assertThat(context).hasSingleBean(FirebaseAuth.class);
                    assertThat(context.getBean(FirebaseAuth.class))
                            .isSameAs(FirebaseAuth.getInstance(context.getBean(FirebaseApp.class)));
                });
    }

    @Test
    void whenDatabaseExplicitlyDisabled_thenNoDatabaseBean() {
        new ApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(FirebaseAutoConfiguration.class))
                .withUserConfiguration(FirebaseTestConfiguration.class)
                .withPropertyValues(
                        "firebase.apps.default.project-id=default-project",
                        "firebase.apps.default.db.url=http://localhost:0",
                        "firebase.apps.default.db.enabled=false",
                        "firebase.apps.default.storage.bucket=default-bucket",
                        "firebase.apps.default.storage.enabled=false"
                )
                .run(context -> {
                    assertThat(context).doesNotHaveBean(FirebaseDatabase.class);
                    assertThat(context).doesNotHaveBean(StorageClient.class);
                });
    }

    @Test
    void propertiesDefaultsMatchAutoConfigurationDefaults() {
        var props = new FirebaseProperties();
        assertThat(props.getDb().isEnabled()).isTrue();
        assertThat(props.getStorage().isEnabled()).isTrue();
        assertThat(props.getAuth().isEnabled()).isFalse();
        assertThat(props.getMessaging().isEnabled()).isFalse();
        assertThat(props.getFirestore().isEnabled()).isFalse();
    }

    @Configuration(proxyBeanMethods = false)
    static class CustomFirebaseAppConfiguration {
        @Bean(destroyMethod = "delete")
        FirebaseApp myFirebaseApp() {
            return FirebaseApp.initializeApp(FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.newBuilder().build())
                    .setProjectId("custom-project")
                    .build(), "custom");
        }
    }
}
