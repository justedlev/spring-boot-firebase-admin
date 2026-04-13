# 🤝 Contributing Guide

Thank you for your interest in contributing!
This project is open to improvements, bug fixes, and new features.

## 🧭 Project Overview

This project provides a Spring Boot starter for integrating Firebase Admin SDK.

It follows:

* Clean modular architecture
* [Conventional Commits](https://www.conventionalcommits.org)
* Automated releases via [release-please](https://github.com/marketplace/actions/release-please-action)
* Maven multi-module structure

## 📦 Project Structure

```text
.
├── firebase-spring-boot
└── firebase-spring-boot-starter
```

### Modules

* **autoconfigure** → core logic and configuration
* **starter** → dependency entrypoint

## 🧑‍💻 Development Guidelines

### Java & Spring

* Use Java 17+
* Follow Spring Boot conventions
* Prefer constructor injection
* Avoid unnecessary abstractions

### Code Style

* Keep code simple and readable
* Use meaningful names
* Avoid premature optimization
* Write small, focused classes

### Tests

* Add tests for new features
* Cover auto-configuration logic
* Use `ApplicationContextRunner` where applicable

## 🧾 Commit Guidelines

This project uses **[Conventional Commits](https://www.conventionalcommits.org)**.

### Examples

```text
feat(starter): add FirebaseAuth auto-configuration
fix(autoconfigure): handle missing credentials
docs(readme): update quick start
refactor(core): simplify credentials provider
```

### Types

| Type     | Description           |
|----------|-----------------------|
| feat     | New feature           |
| fix      | Bug fix               |
| docs     | Documentation         |
| refactor | Code changes (no fix) |
| test     | Tests                 |
| build    | Build system          |
| ci       | CI/CD changes         |
| chore    | Maintenance           |

## 🔄 Pull Request Process

1. Create a feature branch:

```bash
git checkout -b feature/my-feature
```

2. Commit your changes using Conventional Commits

3. Push to your fork:

```bash
git push origin feature/my-feature
```

4. Open a Pull Request

### PR Requirements

* Clear title and description
* Follow commit conventions
* Tests added (if applicable)
* No unrelated changes

## 🏷 Releases

Releases are fully automated.

### Process

1. Commits are pushed to `main`
2. Release PR is created automatically
3. Maintainer reviews & merges PR
4. GitHub Release is created
5. Artifacts are published to Maven Central

## ⚠️ What to Avoid

* Breaking public API without discussion
* Adding heavy dependencies
* Mixing unrelated changes in one PR

## 💡 Feature Requests

If you have an idea:

* Open an issue
* Describe the use case
* Explain expected behavior

## 🐛 Bug Reports

Please include:

* Steps to reproduce
* Expected vs actual behavior
* Logs or stack trace
* Spring Boot version

## 🛠 Areas for Contribution

* Spring Security integration
* Firestore improvements
* Messaging support
* Documentation
* Tests and edge cases

## 📄 License

By contributing, you agree that your contributions will be licensed under the Apache License 2.0.

## 🙌 Thank You

Every contribution matters ❤️
