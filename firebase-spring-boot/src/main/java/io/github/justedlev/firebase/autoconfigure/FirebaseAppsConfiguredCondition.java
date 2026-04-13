package io.github.justedlev.firebase.autoconfigure;

import io.github.justedlev.firebase.FirebaseProperties;
import io.github.justedlev.firebase.config.FirebaseConfigurationProperties;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class FirebaseAppsConfiguredCondition extends SpringBootCondition {
    private static final Bindable<@NonNull Map<String, FirebaseProperties>> BINDABLE =
            Bindable.mapOf(String.class, FirebaseProperties.class);

    @NonNull
    @Override
    public ConditionOutcome getMatchOutcome(@NonNull ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        var exclude = getExclude(metadata);
        var message = ConditionMessage.forCondition("Firebase Apps Configured Condition");
        var appNames = Binder.get(context.getEnvironment())
                .bind(FirebaseConfigurationProperties.PREFIX + ".apps", BINDABLE)
                .orElse(Collections.emptyMap())
                .keySet()
                .stream()
                .filter(Predicate.not(exclude::contains))
                .collect(Collectors.joining(", "));
        if (!appNames.isEmpty()) {
            return ConditionOutcome.match(message.foundExactly("registered firebase apps " + appNames));
        }
        return ConditionOutcome.noMatch(message.notAvailable("registered firebase apps"));
    }

    private Set<String> getExclude(AnnotatedTypeMetadata metadata) {
        return Optional.of(metadata)
                .map(v -> v.getAnnotationAttributes(ConditionalOnFirebaseAppsProperties.class.getName()))
                .map(v -> v.get("exclude"))
                .map(String[].class::cast)
                .map(Set::of)
                .orElseGet(Collections::emptySet);
    }
}
