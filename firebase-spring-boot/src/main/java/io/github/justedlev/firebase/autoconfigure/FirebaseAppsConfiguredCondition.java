package io.github.justedlev.firebase.autoconfigure;

import io.github.justedlev.firebase.config.FirebaseConfigurationProperties;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

class FirebaseAppsConfiguredCondition extends SpringBootCondition {
    private static final String MATCH_MSG = "registered firebase apps";
    private static final Bindable<FirebaseConfigurationProperties> BINDABLE =
            Bindable.of(FirebaseConfigurationProperties.class);

    @NonNull
    @Override
    public ConditionOutcome getMatchOutcome(@NonNull ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        var exclude = getExclude(metadata);
        var message = ConditionMessage.forCondition("Firebase Apps Configured Condition");
        var appNames = Binder.get(context.getEnvironment())
                .bind(FirebaseConfigurationProperties.PREFIX, BINDABLE)
                .orElseGet(FirebaseConfigurationProperties::new)
                .getApps()
                .keySet()
                .stream()
                .filter(Predicate.not(exclude::contains))
                .toList();

        if (appNames.isEmpty()) {
            return ConditionOutcome.noMatch(message.notAvailable(MATCH_MSG));
        }

        return ConditionOutcome.match(message.found(MATCH_MSG).items(ConditionMessage.Style.QUOTE, appNames));
    }

    private Set<String> getExclude(AnnotatedTypeMetadata metadata) {
        return Optional.of(metadata.getAnnotations())
                .map(v -> v.get(ConditionalOnFirebaseAppsProperties.class))
                .map(MergedAnnotation::synthesize)
                .map(ConditionalOnFirebaseAppsProperties::exclude)
                .map(Set::of)
                .orElseGet(Collections::emptySet);
    }
}
