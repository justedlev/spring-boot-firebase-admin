package io.github.justedlev.firebase;

import com.google.firebase.FirebaseOptions;
import org.springframework.boot.context.properties.PropertyMapper;

public record DefaultFirebaseOptionsFactory(FirebaseCredentialsFactory credsFactory) implements FirebaseOptionsFactory {
    @Override
    public FirebaseOptions create(FirebaseProperties properties) {
        var mapper = PropertyMapper.get().alwaysApplyingWhenNonNull();
        var ops = FirebaseOptions.builder();
        mapper.from(properties.getDatabaseAuthVariableOverride()).to(ops::setDatabaseAuthVariableOverride);
        mapper.from(properties.getDatabaseUrl()).to(ops::setDatabaseUrl);
        mapper.from(properties.getProjectId()).to(ops::setProjectId);
        mapper.from(properties.getStorageBucket()).to(ops::setStorageBucket);
        mapper.from(properties.getServiceAccountId()).to(ops::setServiceAccountId);
        mapper.from(credsFactory.create(properties)).to(ops::setCredentials);
        mapper.from(properties.getConnectTimeout()).to(ops::setConnectTimeout);
        mapper.from(properties.getReadTimeout()).to(ops::setReadTimeout);
        mapper.from(properties.getWriteTimeout()).to(ops::setWriteTimeout);
        return ops.build();
    }
}
