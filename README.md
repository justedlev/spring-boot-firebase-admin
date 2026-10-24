<img src="./docs/assets/logo.svg" alt="logo" align="right" height="96" width="96"/>

# Spring Boot Firebase Admin

[![language](https://img.shields.io/badge/Java%2017-e6892e.svg?logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/17/)
[![framework](https://img.shields.io/badge/Spring%20Boot%20-6DB33F.svg?logo=springboot&logoColor=white)](https://docs.spring.io/spring-boot/index.html)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.justedlev/firebase-spring-boot-starter?logo=apachemaven&label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.justedlev/firebase-spring-boot-starter)
[![license](https://img.shields.io/github/license/justedlev/spring-boot-firebase-admin?label=License)](https://github.com/justedlev/spring-boot-firebase-admin)
[![issues](https://img.shields.io/github/issues/justedlev/spring-boot-firebase-admin)](https://github.com/justedlev/spring-boot-firebase-admin/issues)
[![stars](https://img.shields.io/github/stars/justedlev/spring-boot-firebase-admin)](https://github.com/justedlev/spring-boot-firebase-admin)

### 📋 About

A lightweight and production-ready Spring Boot starter for seamless integration with Firebase Admin SDK.

This project simplifies Firebase configuration in Spring Boot applications by providing auto-configuration, sensible
defaults, and flexible credential management.

### 🍃 Spring Boot Compatibility

| Version                                                                                               | Spring Boot    | Status         | Maintenance branch                                                        |
|-------------------------------------------------------------------------------------------------------|----------------|----------------|---------------------------------------------------------------------------|
| 0.x.x                                                                                                 | 3.5.x          | ⚠️ Beta        | —                                                                         |
| [1.x.x](https://central.sonatype.com/artifact/io.github.justedlev/firebase-spring-boot-starter/1.0.0) | [2.7.x, 3.0.0) | ✅ Released     | [`1.x`](https://github.com/justedlev/spring-boot-firebase-admin/tree/1.x) |
| [2.x.x](https://central.sonatype.com/artifact/io.github.justedlev/firebase-spring-boot-starter/2.0.0) | [3.5.x, 4.0.0) | ✅ Released     | [`2.x`](https://github.com/justedlev/spring-boot-firebase-admin/tree/2.x) |
| 3.x.x                                                                                                 | [4.0.x, 5.0.0) | 🚧 In Progress | —                                                                         |

Bug fixes for an older Spring Boot generation should target that line's maintenance branch, not `main`. `main` tracks
the
next, in-development generation; when that work is ready to ship, a new maintenance branch is cut for the line it
supersedes, the same way `1.x` and `2.x` were cut.

### ✨ Features

- ✅ Auto-configures one or more `FirebaseApp`s from `firebase.apps.*`
- ✅ Opt-in service beans per app:
    - `FirebaseAuth`
    - `FirebaseDatabase` (Realtime Database)
    - `FirebaseMessaging` (Cloud Messaging)
    - `StorageClient` (Cloud Storage)
    - `Firestore`
- ✅ Credentials from the classpath, the filesystem, or
  [Application Default Credentials](https://cloud.google.com/docs/authentication/application-default-credentials)
- ✅ Extensible: replace `FirebaseCredentialsFactory` or `FirebaseOptionsFactory` with your own bean
- ✅ Apps are deleted cleanly on context shutdown (DevTools restarts and test contexts work)

### 📦 Usage

#### Maven

<!-- x-release-please-start-version -->

```xml

<dependency>
    <groupId>io.github.justedlev</groupId>
    <artifactId>firebase-spring-boot-starter</artifactId>
    <version>3.0.1</version>
</dependency>
```

<!-- x-release-please-end -->

### ⚙️ Quick Start

1. Add configuration

```yaml
firebase:
  apps:
    default:
      project-id: <your-project-id>
      # omit to use Application Default Credentials
      credentials: classpath:firebase-service-account.json
      auth:
        enabled: true
      db:
        url: https://<your-project-id>-default-rtdb.firebaseio.com
```

2. Inject Firebase beans

```java

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final FirebaseAuth firebaseAuth;

    @GetMapping("/users/{uid}")
    public String email(@PathVariable String uid) throws FirebaseAuthException {
        return firebaseAuth.getUser(uid).getEmail();
    }
}
```

### 🧩 Multiple apps

Every key under `firebase.apps` other than `default` registers a `FirebaseApp` bean named
`<key>FirebaseApp`, plus `<key>FirebaseAuth`, `<key>FirebaseDatabase`, `<key>FirebaseMessaging`,
`<key>StorageClient` and `<key>Firestore` for the services enabled on it. The Firebase app name defaults to the key.

```yaml
firebase:
  apps:
    default:
      project-id: main-project
      auth:
        enabled: true
    analytics:
      project-id: analytics-project
      credentials: file:/etc/secrets/analytics.json
      firestore:
        enabled: true
```

```java
public AnalyticsService(@Qualifier("analyticsFirestore") Firestore firestore) { ... }
```

The `default` app's beans are `@Primary`, so they are injected when no qualifier is given.

### 📚 Configuration Reference

> [!NOTE]
> `<app>` is any key under `firebase.apps`. `default` is the primary app.

| Property                                              | Description                                                                                                      | Default                           |
|-------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------|
| `firebase.enabled`                                    | Enable Firebase auto-configuration                                                                               | `true`                            |
| `firebase.apps.<app>.name`                            | Firebase app name                                                                                                | `[DEFAULT]` for `default`, else the key |
| `firebase.apps.<app>.project-id`                      | Google Cloud project ID                                                                                          | -                                 |
| `firebase.apps.<app>.credentials`                     | Credentials JSON location, e.g. `classpath:firebase.json` or `file:/etc/firebase.json`                           | Application Default Credentials   |
| `firebase.apps.<app>.service-account-id`              | Service account email used to sign custom tokens                                                                 | -                                 |
| `firebase.apps.<app>.database-auth-variable-override` | Value of the `auth` variable in Realtime Database security rules                                                 | -                                 |
| `firebase.apps.<app>.connect-timeout`                 | HTTP connect timeout, e.g. `5s` (plain numbers are milliseconds)                                                 | SDK default                       |
| `firebase.apps.<app>.read-timeout`                    | HTTP read timeout                                                                                                | SDK default                       |
| `firebase.apps.<app>.write-timeout`                   | HTTP write timeout                                                                                               | SDK default                       |
| `firebase.apps.<app>.auth.enabled`                    | Register a `FirebaseAuth` bean                                                                                   | `false`                           |
| `firebase.apps.<app>.db.url`                          | Realtime Database URL; registers a `FirebaseDatabase` bean when set                                             | -                                 |
| `firebase.apps.<app>.db.enabled`                      | Set to `false` to skip the `FirebaseDatabase` bean even though `db.url` is set                                   | `true`                            |
| `firebase.apps.<app>.messaging.enabled`               | Register a `FirebaseMessaging` bean                                                                              | `false`                           |
| `firebase.apps.<app>.storage.bucket`                  | Default Cloud Storage bucket (no `gs://` prefix); registers a `StorageClient` bean when set                     | -                                 |
| `firebase.apps.<app>.storage.enabled`                 | Set to `false` to skip the `StorageClient` bean even though `storage.bucket` is set                              | `true`                            |
| `firebase.apps.<app>.firestore.enabled`               | Register a `Firestore` bean                                                                                      | `false`                           |

### 🧪 Firebase Emulator Suite

The Admin SDK switches to the emulators when `FIREBASE_AUTH_EMULATOR_HOST`, `FIREBASE_DATABASE_EMULATOR_HOST` or
`FIRESTORE_EMULATOR_HOST` are set (`firebase emulators:exec` sets them for you). Use a `demo-` project ID so nothing
can reach a real project. `StorageClient` does not support the Storage emulator.

### 🔧 Customization

Declare your own `FirebaseCredentialsFactory` or `FirebaseOptionsFactory` bean to replace the defaults, for example
to load credentials from a secrets manager:

```java

@Bean
FirebaseCredentialsFactory firebaseCredentialsFactory(SecretClient secrets) {
    return properties -> {
        try (var in = secrets.read(properties.getProjectId())) {
            return GoogleCredentials.fromStream(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    };
}
```

### 🤝 Contributing

Please see [CONTRIBUTING.md](./CONTRIBUTING.md)

### 📄 License

This project is licensed under the Apache License 2.0.

### ⚠️ Disclaimer

This project is not affiliated with or endorsed by Google Firebase or Spring.

### ⭐ Support

If you find this project useful:

- ⭐ Star the repository
- 🐛 Report issues
- 💡 Suggest features
