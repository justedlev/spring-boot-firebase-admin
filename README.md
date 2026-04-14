<img src="./docs/assets/logo.svg" alt="logo" align="right" height="96" width="96"/>
<h1>Spring Boot Starter Firebase Admin</h1>

[![language](https://img.shields.io/badge/Java%2017-e6892e.svg?logo=openjdk&logoColor=white)](https://github.com/justedlev/bridgewayhub)
[![framework](https://img.shields.io/badge/Spring%20Boot%20-6DB33F.svg?logo=springboot&logoColor=white)](https://docs.spring.io/spring-boot/index.html)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.justedlev/spring-boot-firebase-admin?logo=apachemaven&label=Maven%20Central)](https://central.sonatype.com/search?q=io.github.justedlev.firebase-spring-boot-starter)
[![license](https://img.shields.io/github/license/justedlev/spring-boot-firebase-admin?label=License)](https://github.com/justedlev/spring-boot-firebase-admin)
[![issues](https://img.shields.io/github/issues/justedlev/spring-boot-firebase-admin)](https://github.com/justedlev/spring-boot-firebase-admin/issues)
[![stars](https://img.shields.io/github/stars/justedlev/spring-boot-firebase-admin)](https://github.com/justedlev/spring-boot-firebase-admin)

### 📋 About

A lightweight and production-ready Spring Boot starter for seamless integration with Firebase Admin SDK.

This project simplifies Firebase configuration in Spring Boot applications by providing auto-configuration, sensible
defaults, and flexible credential management.

### 🍃 Spring Boot Compatibility

| Version | Spring Boot | Status  |
|---------|-------------|---------|
| 0.x.x   | 3.5.x       | ⚠️ Beta |
| 1.x.x   | 2.7.x       | N/A     |
| 2.x.x   | 3.5.x       | N/A     |
| 3.x.x   | 4.x.x       | N/A     |

### ✨ Features

- ✅ Auto-configures FirebaseApp
- ✅ Provides ready-to-use beans:
  - FirebaseAuth
  - FirebaseDatabase
  - FirebaseMessaging
- ✅ Supports multiple credential sources:
  - classpath
  - filesystem
- ✅ Modular and extensible design
- ✅ Works with multi-module Spring Boot projects
- ✅ Minimal configuration required

### 📦 Usage

#### Maven

<!-- x-release-please-start-version -->

```xml

<dependency>
    <groupId>io.github.justedlev</groupId>
    <artifactId>firebase-spring-boot-starter</artifactId>
    <version>0.1.0</version>
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
      auth:
        enabled: true
      db:
        enabled: true
      messaging:
        enabled: false
```

2. Inject Firebase beans

```java

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class DemoController {
    private final FirebaseAuth firebaseAuth;

    @GetMapping("/firebase/status")
    public String status() {
        return "Firebase initialized: " + (firebaseAuth != null);
    }
}
```

### 📚 Configuration Reference

> [!WARNING]
> Property marked `*` is required

> [!NOTE]
> By default, you can use the predefined FirebaseApp properties using `firebase.apps.default.*`

| Property                                                   | Description                                                                                   | Default                                                                   |
|------------------------------------------------------------|-----------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| `firebase.enabled`                                         | Enable Firebase integration                                                                   | `true`                                                                    |
| `firebase.apps.<app-name>.name`*                           | Unique name for the Firebase app                                                              | `[DEFAULT]`                                                               |
| `firebase.apps.<app-name>.database-auth-variable-override` | The value to use for the `auth` variable in the security rules for Realtime Database actions. | -                                                                         |
| `firebase.apps.<app-name>.database-url`                    | The Realtime Database URL to use for data storage.                                            | `https://${firebase.apps.default.project-id}-default-rtdb.firebaseio.com` |
| `firebase.apps.<app-name>.project-id`*                     | Firebase project ID                                                                           | -                                                                         |
| `firebase.apps.<app-name>.storage-bucket`                  | The full name of an existing Google Cloud Storage bucket, excluding any protocol prefixes     | -                                                                         |
| `firebase.apps.<app-name>.service-account-id`              | Service account email address string                                                          | -                                                                         |
| `firebase.apps.<app-name>.credentials`*                    | Credentials used to authenticate the SDK                                                      | `file:${user.home}/.firebase/${firebase.apps.default.project-id}.json`    |
| `firebase.apps.<app-name>.connect-timeout`                 | Connect timeout                                                                               | -                                                                         |
| `firebase.apps.<app-name>.read-timeout`                    | Read timeout                                                                                  | -                                                                         |
| `firebase.apps.<app-name>.write-timeout`                   | Write timeout                                                                                 | -                                                                         |
| `firebase.apps.<app-name>.auth.enabled`                    | Enabling FirebaseAuth bean                                                                    | `false`                                                                   |
| `firebase.apps.<app-name>.db.enabled`                      | Enabling FirebaseDatabase bean                                                                | `false`                                                                   |
| `firebase.apps.<app-name>.messaging.enabled`               | Enabling FirebaseMessaging bean                                                               | `false`                                                                   |

> [!TIP]
> When `firebase.apps.<app-name>.database-url` is configured,
> the `firebase.apps.<app-name>.db.enabled` property is not required.

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
