package io.github.justedlev.firebase;

import com.google.firebase.FirebaseOptions;
import org.springframework.boot.context.properties.PropertyMapper;

import java.time.Duration;

public record DefaultFirebaseOptionsFactory(FirebaseCredentialsFactory credsFactory) implements FirebaseOptionsFactory {
    @Override
    public FirebaseOptions create(FirebaseProperties properties) {
        var mapper = PropertyMapper.get();
        var ops = FirebaseOptions.builder();
        mapper.from(properties.getDatabaseAuthVariableOverride()).to(ops::setDatabaseAuthVariableOverride);
        mapper.from(properties.getDb())
                .as(FirebaseDatabaseProperties::getUrl)
                .whenHasText()
                .to(ops::setDatabaseUrl);
        mapper.from(properties.getProjectId()).to(ops::setProjectId);
        mapper.from(properties.getStorage())
                .as(StorageProperties::getBucket)
                .whenHasText()
                .to(ops::setStorageBucket);
        mapper.from(properties.getServiceAccountId()).to(ops::setServiceAccountId);
        mapper.from(credsFactory.create(properties)).to(ops::setCredentials);
        mapper.from(properties.getConnectTimeout()).asInt(Duration::toMillis).to(ops::setConnectTimeout);
        mapper.from(properties.getReadTimeout()).asInt(Duration::toMillis).to(ops::setReadTimeout);
        mapper.from(properties.getWriteTimeout()).asInt(Duration::toMillis).to(ops::setWriteTimeout);
        return ops.build();
    }
}
