# 📦 Changelog

All notable changes to this project will be documented in this file.

This project uses **[Conventional Commits](https://www.conventionalcommits.org/)** and is powered by *
*[release-please](https://github.com/googleapis/release-please)**.

## [2.0.0](https://github.com/justedlev/spring-boot-firebase-admin/compare/spring-boot-firebase-admin-2x-v2.0.1...spring-boot-firebase-admin-2x-v2.0.0) (2026-07-06)


### revert

* reverts commit dc953555 ([0499b6c](https://github.com/justedlev/spring-boot-firebase-admin/commit/0499b6c05c2371d835d1e3e7f548ea77e70d7e51))


### 🚀 Features

* **config:** add beans init ([41bdef4](https://github.com/justedlev/spring-boot-firebase-admin/commit/41bdef45b86da0d6b07f00e8e90f27afe579109f))
* **config:** add more condition on bean creation ([7a3b07c](https://github.com/justedlev/spring-boot-firebase-admin/commit/7a3b07c1116bb1482a3d832d745a32275bdb59a7))
* **config:** use google application default creds on empty property ([8dbb323](https://github.com/justedlev/spring-boot-firebase-admin/commit/8dbb3232dfbde8772c62a2d35071416b7ac17f80))
* optimize for spring boot v2 ([dc95355](https://github.com/justedlev/spring-boot-firebase-admin/commit/dc95355560a41320d19a2aa0bc2e585e381b05cb))
* **propertis:** add auth property ([4a090fb](https://github.com/justedlev/spring-boot-firebase-admin/commit/4a090fb3985157f1f490dbb6948d524ae4d8db5e))
* **propertis:** add db property ([8777450](https://github.com/justedlev/spring-boot-firebase-admin/commit/8777450411d72c36e350913677a72e52b9b3c725))
* **propertis:** add messaging property ([a3e2bf6](https://github.com/justedlev/spring-boot-firebase-admin/commit/a3e2bf6c52da92d9d019d462ac541b15c1be8b47))


### 🐛 Bug Fixes

* backport post-2.0.0 fixes from develop ([23b7ad2](https://github.com/justedlev/spring-boot-firebase-admin/commit/23b7ad2ec43c4e0606bd56bf319c46d463c47649))
* **build:** remove extra `spring-boot.version` property ([f7b815e](https://github.com/justedlev/spring-boot-firebase-admin/commit/f7b815eb511eb48d3f97e48be91a2c372c4babd6))
* **config:** add matchIfMissing on FirebaseDatabase bean creation ([c7fe002](https://github.com/justedlev/spring-boot-firebase-admin/commit/c7fe002a6fd9750b1cecf0fc95878717fe67f72f))
* **config:** fail on NPE ([0f8cbba](https://github.com/justedlev/spring-boot-firebase-admin/commit/0f8cbbae6637829a964e4fa4ad91a3fb550f16e2))


### ♻️ Refactoring

* add `[@lombok](https://github.com/lombok).Builder.Default` on fields ([8e048b1](https://github.com/justedlev/spring-boot-firebase-admin/commit/8e048b1f44c09d019672bace4fd3fbd9c82f8bca))
* **config:** change primitive to wrapper ([30322bb](https://github.com/justedlev/spring-boot-firebase-admin/commit/30322bb75c27b041a919499fab2c96d04fa18811))
* **config:** improve code ([570ae7f](https://github.com/justedlev/spring-boot-firebase-admin/commit/570ae7fd8f296ad1764b3802250f9a0e2adf5edd))
* **config:** remove unused `io.github.justedlev.firebase.config.FirebaseConfigurationProperties#setDefaultApp` method ([000fcbe](https://github.com/justedlev/spring-boot-firebase-admin/commit/000fcbecfce9424ebe8db84b43eb9bb28158b6ff))
* **config:** rename .imports ([1053e86](https://github.com/justedlev/spring-boot-firebase-admin/commit/1053e863c8b4f0e8abc1e58a445afa8bebca6190))
* **config:** use `gcloud` default cred path ([14370f3](https://github.com/justedlev/spring-boot-firebase-admin/commit/14370f39bee8a5116dcd39ab30815cc31f1acdc7))


### 📚 Documentation

* update README with correct links and formatting adjustments ([32d5051](https://github.com/justedlev/spring-boot-firebase-admin/commit/32d50510727919c50cd022eae6e6c91afd4e4c28))
* update README.md ([dde1b41](https://github.com/justedlev/spring-boot-firebase-admin/commit/dde1b412603b04e3a1eba7f8cc1635ffbd1338db))
* update README.md ([b5eb89f](https://github.com/justedlev/spring-boot-firebase-admin/commit/b5eb89f645798fd3bab5a7561ce195cc4a9dc316))
* Update README.md ([50d4fc1](https://github.com/justedlev/spring-boot-firebase-admin/commit/50d4fc1db02f5f84806c2b143ff1e8264ca0b897))
* update README.md and add CONTRIBUTING.md ([9c32ae7](https://github.com/justedlev/spring-boot-firebase-admin/commit/9c32ae7cc047aa067233333283105ca39dedc13d))


### 🧪 Tests

* add more tests ([fffd2ff](https://github.com/justedlev/spring-boot-firebase-admin/commit/fffd2ff6d3e968b587602a7a89ceaaaa9e6e2c58))
* update `FirebaseAutoConfigurationTest.java` ([6ad8395](https://github.com/justedlev/spring-boot-firebase-admin/commit/6ad839507b28824c952b5a9ea50db9186191f525))


### ⚙️ Build

* **deps:** bump com.google.firebase:firebase-admin from 9.8.0 to 9.9.0 ([797922b](https://github.com/justedlev/spring-boot-firebase-admin/commit/797922b128b51bc6ecac1d2a066876e3eaece002))
* **deps:** bump org.springframework.boot:spring-boot-dependencies from 3.5.0 to 3.5.14 ([2c34e9d](https://github.com/justedlev/spring-boot-firebase-admin/commit/2c34e9d14dc9f16a037552adc99fedd034272365))
* **deps:** com.google.firebase-firebase-admin from 9.8.0 to 9.9.0 ([d199b7b](https://github.com/justedlev/spring-boot-firebase-admin/commit/d199b7b321064abe1c7622c3e7b981e3f0cd2870))
* **deps:** org.springframework.boot:spring-boot-dependencies from 3.5.0 to 3.5.14 ([3786c00](https://github.com/justedlev/spring-boot-firebase-admin/commit/3786c001588f894c5108a2c8aec92c4346ec8e5d))

## [2.0.1](https://github.com/justedlev/spring-boot-firebase-admin/compare/v2.0.0...v2.0.1) (2026-07-05)


### 🐛 Bug Fixes

* backport post-2.0.0 fixes from develop ([23b7ad2](https://github.com/justedlev/spring-boot-firebase-admin/commit/23b7ad2ec43c4e0606bd56bf319c46d463c47649))


### 📚 Documentation

* update README with correct links and formatting adjustments ([32d5051](https://github.com/justedlev/spring-boot-firebase-admin/commit/32d50510727919c50cd022eae6e6c91afd4e4c28))

## [2.0.0](https://github.com/justedlev/spring-boot-firebase-admin/compare/v1.0.0...v2.0.0) (2026-06-16)


### revert

* reverts commit dc953555 ([0499b6c](https://github.com/justedlev/spring-boot-firebase-admin/commit/0499b6c05c2371d835d1e3e7f548ea77e70d7e51))


### 🚀 Features

* **config:** add beans init ([41bdef4](https://github.com/justedlev/spring-boot-firebase-admin/commit/41bdef45b86da0d6b07f00e8e90f27afe579109f))
* **config:** add more condition on bean creation ([7a3b07c](https://github.com/justedlev/spring-boot-firebase-admin/commit/7a3b07c1116bb1482a3d832d745a32275bdb59a7))
* **config:** use google application default creds on empty property ([8dbb323](https://github.com/justedlev/spring-boot-firebase-admin/commit/8dbb3232dfbde8772c62a2d35071416b7ac17f80))
* optimize for spring boot v2 ([dc95355](https://github.com/justedlev/spring-boot-firebase-admin/commit/dc95355560a41320d19a2aa0bc2e585e381b05cb))
* **propertis:** add auth property ([4a090fb](https://github.com/justedlev/spring-boot-firebase-admin/commit/4a090fb3985157f1f490dbb6948d524ae4d8db5e))
* **propertis:** add db property ([8777450](https://github.com/justedlev/spring-boot-firebase-admin/commit/8777450411d72c36e350913677a72e52b9b3c725))
* **propertis:** add messaging property ([a3e2bf6](https://github.com/justedlev/spring-boot-firebase-admin/commit/a3e2bf6c52da92d9d019d462ac541b15c1be8b47))


### 🐛 Bug Fixes

* **build:** remove extra `spring-boot.version` property ([f7b815e](https://github.com/justedlev/spring-boot-firebase-admin/commit/f7b815eb511eb48d3f97e48be91a2c372c4babd6))
* **config:** add matchIfMissing on FirebaseDatabase bean creation ([c7fe002](https://github.com/justedlev/spring-boot-firebase-admin/commit/c7fe002a6fd9750b1cecf0fc95878717fe67f72f))
* **config:** fail on NPE ([0f8cbba](https://github.com/justedlev/spring-boot-firebase-admin/commit/0f8cbbae6637829a964e4fa4ad91a3fb550f16e2))


### ♻️ Refactoring

* add `[@lombok](https://github.com/lombok).Builder.Default` on fields ([8e048b1](https://github.com/justedlev/spring-boot-firebase-admin/commit/8e048b1f44c09d019672bace4fd3fbd9c82f8bca))
* **config:** change primitive to wrapper ([30322bb](https://github.com/justedlev/spring-boot-firebase-admin/commit/30322bb75c27b041a919499fab2c96d04fa18811))
* **config:** improve code ([570ae7f](https://github.com/justedlev/spring-boot-firebase-admin/commit/570ae7fd8f296ad1764b3802250f9a0e2adf5edd))
* **config:** remove unused `io.github.justedlev.firebase.config.FirebaseConfigurationProperties#setDefaultApp` method ([000fcbe](https://github.com/justedlev/spring-boot-firebase-admin/commit/000fcbecfce9424ebe8db84b43eb9bb28158b6ff))
* **config:** rename .imports ([1053e86](https://github.com/justedlev/spring-boot-firebase-admin/commit/1053e863c8b4f0e8abc1e58a445afa8bebca6190))
* **config:** use `gcloud` default cred path ([14370f3](https://github.com/justedlev/spring-boot-firebase-admin/commit/14370f39bee8a5116dcd39ab30815cc31f1acdc7))


### 📚 Documentation

* update README.md ([dde1b41](https://github.com/justedlev/spring-boot-firebase-admin/commit/dde1b412603b04e3a1eba7f8cc1635ffbd1338db))
* update README.md ([b5eb89f](https://github.com/justedlev/spring-boot-firebase-admin/commit/b5eb89f645798fd3bab5a7561ce195cc4a9dc316))
* Update README.md ([50d4fc1](https://github.com/justedlev/spring-boot-firebase-admin/commit/50d4fc1db02f5f84806c2b143ff1e8264ca0b897))
* update README.md and add CONTRIBUTING.md ([9c32ae7](https://github.com/justedlev/spring-boot-firebase-admin/commit/9c32ae7cc047aa067233333283105ca39dedc13d))


### 🧪 Tests

* add more tests ([fffd2ff](https://github.com/justedlev/spring-boot-firebase-admin/commit/fffd2ff6d3e968b587602a7a89ceaaaa9e6e2c58))
* update `FirebaseAutoConfigurationTest.java` ([6ad8395](https://github.com/justedlev/spring-boot-firebase-admin/commit/6ad839507b28824c952b5a9ea50db9186191f525))


### ⚙️ Build

* **deps:** bump com.google.firebase:firebase-admin from 9.8.0 to 9.9.0 ([797922b](https://github.com/justedlev/spring-boot-firebase-admin/commit/797922b128b51bc6ecac1d2a066876e3eaece002))
* **deps:** bump org.springframework.boot:spring-boot-dependencies from 3.5.0 to 3.5.14 ([2c34e9d](https://github.com/justedlev/spring-boot-firebase-admin/commit/2c34e9d14dc9f16a037552adc99fedd034272365))
* **deps:** com.google.firebase-firebase-admin from 9.8.0 to 9.9.0 ([d199b7b](https://github.com/justedlev/spring-boot-firebase-admin/commit/d199b7b321064abe1c7622c3e7b981e3f0cd2870))
* **deps:** org.springframework.boot:spring-boot-dependencies from 3.5.0 to 3.5.14 ([3786c00](https://github.com/justedlev/spring-boot-firebase-admin/commit/3786c001588f894c5108a2c8aec92c4346ec8e5d))

## [1.0.0](https://github.com/justedlev/spring-boot-firebase-admin/compare/v0.2.1...v1.0.0) (2026-06-16)


### 🚀 Features

* optimize for spring boot v2 ([dc95355](https://github.com/justedlev/spring-boot-firebase-admin/commit/dc95355560a41320d19a2aa0bc2e585e381b05cb))

## [0.2.1](https://github.com/justedlev/spring-boot-firebase-admin/compare/v0.2.0...v0.2.1) (2026-06-07)


### 🐛 Bug Fixes

* **build:** remove extra `spring-boot.version` property ([f7b815e](https://github.com/justedlev/spring-boot-firebase-admin/commit/f7b815eb511eb48d3f97e48be91a2c372c4babd6))


### ⚙️ Build

* **deps:** bump com.google.firebase:firebase-admin from 9.8.0 to 9.9.0 ([797922b](https://github.com/justedlev/spring-boot-firebase-admin/commit/797922b128b51bc6ecac1d2a066876e3eaece002))
* **deps:** bump org.springframework.boot:spring-boot-dependencies from 3.5.0 to 3.5.14 ([2c34e9d](https://github.com/justedlev/spring-boot-firebase-admin/commit/2c34e9d14dc9f16a037552adc99fedd034272365))
* **deps:** com.google.firebase-firebase-admin from 9.8.0 to 9.9.0 ([d199b7b](https://github.com/justedlev/spring-boot-firebase-admin/commit/d199b7b321064abe1c7622c3e7b981e3f0cd2870))
* **deps:** org.springframework.boot:spring-boot-dependencies from 3.5.0 to 3.5.14 ([3786c00](https://github.com/justedlev/spring-boot-firebase-admin/commit/3786c001588f894c5108a2c8aec92c4346ec8e5d))

## [0.2.0](https://github.com/justedlev/spring-boot-firebase-admin/compare/v0.1.0...v0.2.0) (2026-06-06)


### 🚀 Features

* **config:** add beans init ([41bdef4](https://github.com/justedlev/spring-boot-firebase-admin/commit/41bdef45b86da0d6b07f00e8e90f27afe579109f))
* **config:** use google application default creds on empty property ([8dbb323](https://github.com/justedlev/spring-boot-firebase-admin/commit/8dbb3232dfbde8772c62a2d35071416b7ac17f80))


### 🐛 Bug Fixes

* **config:** fail on NPE ([0f8cbba](https://github.com/justedlev/spring-boot-firebase-admin/commit/0f8cbbae6637829a964e4fa4ad91a3fb550f16e2))


### ♻️ Refactoring

* add `[@lombok](https://github.com/lombok).Builder.Default` on fields ([8e048b1](https://github.com/justedlev/spring-boot-firebase-admin/commit/8e048b1f44c09d019672bace4fd3fbd9c82f8bca))
* **config:** improve code ([570ae7f](https://github.com/justedlev/spring-boot-firebase-admin/commit/570ae7fd8f296ad1764b3802250f9a0e2adf5edd))
* **config:** remove unused `io.github.justedlev.firebase.config.FirebaseConfigurationProperties#setDefaultApp` method ([000fcbe](https://github.com/justedlev/spring-boot-firebase-admin/commit/000fcbecfce9424ebe8db84b43eb9bb28158b6ff))
* **config:** rename .imports ([1053e86](https://github.com/justedlev/spring-boot-firebase-admin/commit/1053e863c8b4f0e8abc1e58a445afa8bebca6190))
* **config:** use `gcloud` default cred path ([14370f3](https://github.com/justedlev/spring-boot-firebase-admin/commit/14370f39bee8a5116dcd39ab30815cc31f1acdc7))


### 📚 Documentation

* update README.md ([dde1b41](https://github.com/justedlev/spring-boot-firebase-admin/commit/dde1b412603b04e3a1eba7f8cc1635ffbd1338db))
* update README.md ([b5eb89f](https://github.com/justedlev/spring-boot-firebase-admin/commit/b5eb89f645798fd3bab5a7561ce195cc4a9dc316))
* Update README.md ([50d4fc1](https://github.com/justedlev/spring-boot-firebase-admin/commit/50d4fc1db02f5f84806c2b143ff1e8264ca0b897))

## [0.1.0](https://github.com/justedlev/spring-boot-firebase-admin/compare/v0.0.1...v0.1.0) (2026-04-14)


### 🚀 Features

* **config:** add more condition on bean creation ([7a3b07c](https://github.com/justedlev/spring-boot-firebase-admin/commit/7a3b07c1116bb1482a3d832d745a32275bdb59a7))
* **propertis:** add auth property ([4a090fb](https://github.com/justedlev/spring-boot-firebase-admin/commit/4a090fb3985157f1f490dbb6948d524ae4d8db5e))
* **propertis:** add db property ([8777450](https://github.com/justedlev/spring-boot-firebase-admin/commit/8777450411d72c36e350913677a72e52b9b3c725))
* **propertis:** add messaging property ([a3e2bf6](https://github.com/justedlev/spring-boot-firebase-admin/commit/a3e2bf6c52da92d9d019d462ac541b15c1be8b47))


### 🐛 Bug Fixes

* **config:** add matchIfMissing on FirebaseDatabase bean creation ([c7fe002](https://github.com/justedlev/spring-boot-firebase-admin/commit/c7fe002a6fd9750b1cecf0fc95878717fe67f72f))


### ♻️ Refactoring

* **config:** change primitive to wrapper ([30322bb](https://github.com/justedlev/spring-boot-firebase-admin/commit/30322bb75c27b041a919499fab2c96d04fa18811))


### 📚 Documentation

* update README.md and add CONTRIBUTING.md ([9c32ae7](https://github.com/justedlev/spring-boot-firebase-admin/commit/9c32ae7cc047aa067233333283105ca39dedc13d))


### 🧪 Tests

* add more tests ([fffd2ff](https://github.com/justedlev/spring-boot-firebase-admin/commit/fffd2ff6d3e968b587602a7a89ceaaaa9e6e2c58))
* update `FirebaseAutoConfigurationTest.java` ([6ad8395](https://github.com/justedlev/spring-boot-firebase-admin/commit/6ad839507b28824c952b5a9ea50db9186191f525))

## 0.0.1 (2026-04-13)


### 🧹 Chores

* release 0.0.1 ([154bfd5](https://github.com/justedlev/spring-boot-firebase-admin/commit/154bfd5b34f58c945b21393f0664f99089b15a7b))

## [0.0.3](https://github.com/justedlev/spring-boot-firebase-admin/compare/v0.0.2...v0.0.3) (2026-04-13)

### ⚙️ Build

* **maven:** fix incorrect dependency
  usage ([90315ff](https://github.com/justedlev/spring-boot-firebase-admin/commit/90315ff9fb9941302ac4312e4d1882029cbdbcd5))

## [0.0.2](https://github.com/justedlev/spring-boot-firebase-admin/compare/v0.0.1...v0.0.2) (2026-04-13)

### 🐛 Bug Fixes

* **config:** `@Builder` will ignore the initializing expression
  entirely ([e590985](https://github.com/justedlev/spring-boot-firebase-admin/commit/e5909853d48cc7c3f563712228351093fe13cc8b))
* **config:** NPE on FirebaseOptions
  insert ([55987cf](https://github.com/justedlev/spring-boot-firebase-admin/commit/55987cf979bd124f06e882d811c4b1e631f60ce1))

### 🧪 Tests

* **config:** fix test scope
  config ([cff72e6](https://github.com/justedlev/spring-boot-firebase-admin/commit/cff72e6077a0e611ccaf5eabc65417a26befe2ad))

### ⚙️ Build

* **maven:** exclude `commons-logging:commons-logging` from
  `com.google.firebase:firebase-admin` ([a047992](https://github.com/justedlev/spring-boot-firebase-admin/commit/a0479923939e6aacdd3f333368ff8a98d2ff2791))
* **maven:** remove unused
  dependency ([3a9e4f1](https://github.com/justedlev/spring-boot-firebase-admin/commit/3a9e4f1c03b1b904914f7e4249c7263d4696021d))

## 0.0.1 (2026-04-12)

### 🚀 Features

* add base
  implementation ([7e670d7](https://github.com/justedlev/spring-boot-firebase-admin/commit/7e670d7bba2fd26d65186adaafe116f1dc4fb451))
* **config:** add
  `lombok.config` ([1dc8936](https://github.com/justedlev/spring-boot-firebase-admin/commit/1dc89363b123b2b51b9e341dd60936be5795cb59))

### 🧹 Chores

* **github:** add issue and pr
  templates ([497715a](https://github.com/justedlev/spring-boot-firebase-admin/commit/497715a1bfc284ce2ae689a0d051b975e0f181c7))
* initial
  commit ([9309337](https://github.com/justedlev/spring-boot-firebase-admin/commit/93093375d274b885e2d5ce648aec9138288b3963))

### 🔧 CI/CD

* **github:** add `assignee`
  workflow ([09e6d78](https://github.com/justedlev/spring-boot-firebase-admin/commit/09e6d78603ff12434a8a0fddb63d98684a897ad1))
* **github:** add `dependabot`
  workflow ([e0164f1](https://github.com/justedlev/spring-boot-firebase-admin/commit/e0164f10f46c04fd3184b319947c8bcbe817274d))
* **github:** add `release-please`
  workflow ([8b5cd14](https://github.com/justedlev/spring-boot-firebase-admin/commit/8b5cd14d65c044dc324bc9850c8765faa459e503))
* **github:** add auto labeler
  workflow ([8ede9e8](https://github.com/justedlev/spring-boot-firebase-admin/commit/8ede9e861e866cdd1a9be21a62bcc11cae90d33f)),
  closes [#3](https://github.com/justedlev/spring-boot-firebase-admin/issues/3)

### ⚙️ Build

* **mvn:** add
  `pom.xml` ([5415349](https://github.com/justedlev/spring-boot-firebase-admin/commit/54153499f5eeb6d7406176d07513a062b3a75449))
* **mvn:** add maven
  wrapper ([f7c8f18](https://github.com/justedlev/spring-boot-firebase-admin/commit/f7c8f18d034861a83c98881c228d25f3ee5cdc01))

## [Unreleased]

_Changes that are in progress but not yet released._

<!-- RELEASE PLEASE INSERT CHANGELOG HERE -->
