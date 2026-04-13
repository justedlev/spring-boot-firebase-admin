package io.github.justedlev.firebase.autoconfigure;

import io.github.justedlev.firebase.config.FirebaseConfigurationProperties;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(FirebaseAppsConfiguredCondition.class)
public @interface ConditionalOnFirebaseAppsProperties {
    String[] exclude() default {FirebaseConfigurationProperties.DEFAULT_APP_NAME};
}
