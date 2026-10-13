package io.github.justedlev.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.UserCredentials;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.DefaultResourceLoader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class DefaultFirebaseCredentialsFactoryTest {
    private final DefaultFirebaseCredentialsFactory factory =
            new DefaultFirebaseCredentialsFactory(new DefaultResourceLoader());

    @Test
    void whenCredentialsLocationSet_thenLoadedFromResource() {
        var props = FirebaseProperties.builder().credentials("classpath:test-credentials.json").build();

        var credentials = factory.create(props);

        assertThat(credentials).isInstanceOf(UserCredentials.class);
        assertThat(((UserCredentials) credentials).getClientId()).isEqualTo("test-client-id");
    }

    @Test
    void whenCredentialsLocationMissing_thenFailsWithLocation() {
        var props = FirebaseProperties.builder().credentials("classpath:missing.json").build();

        assertThatIllegalStateException()
                .isThrownBy(() -> factory.create(props))
                .withMessageContaining("classpath:missing.json");
    }

    @Test
    void whenCredentialsNotSet_thenApplicationDefaultUsed() {
        var adc = GoogleCredentials.newBuilder().build();
        try (var mocked = Mockito.mockStatic(GoogleCredentials.class)) {
            mocked.when(GoogleCredentials::getApplicationDefault).thenReturn(adc);

            assertThat(factory.create(new FirebaseProperties())).isSameAs(adc);
        }
    }
}
