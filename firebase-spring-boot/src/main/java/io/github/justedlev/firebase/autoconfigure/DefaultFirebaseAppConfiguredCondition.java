package io.github.justedlev.firebase.autoconfigure;

import io.github.justedlev.firebase.config.FirebaseConfigurationProperties;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Matches only when a Firebase application named {@code default} is configured under
 * {@code firebase.apps}. Prevents the default application beans from being created (and
 * failing with a {@link NullPointerException}) when the user configures named apps only.
 */
class DefaultFirebaseAppConfiguredCondition extends SpringBootCondition {
    private static final String MATCH_MSG = "default firebase app";
    private static final Bindable<@NonNull FirebaseConfigurationProperties> BINDABLE =
            Bindable.of(FirebaseConfigurationProperties.class);

    @NonNull
    @Override
    public ConditionOutcome getMatchOutcome(@NonNull ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        var message = ConditionMessage.forCondition("Default Firebase App Configured Condition");
        var hasDefault = Binder.get(context.getEnvironment())
                .bind(FirebaseConfigurationProperties.PREFIX, BINDABLE)
                .orElseGet(FirebaseConfigurationProperties::new)
                .getApps()
                .containsKey(FirebaseConfigurationProperties.DEFAULT_APP_NAME);

        if (hasDefault) {
            return ConditionOutcome.match(message.found(MATCH_MSG).items(FirebaseConfigurationProperties.DEFAULT_APP_NAME));
        }

        return ConditionOutcome.noMatch(message.notAvailable(MATCH_MSG));
    }
}
