# 📦 Changelog

All notable changes to this project will be documented in this file.

This project uses **[Conventional Commits](https://www.conventionalcommits.org/)** and is powered by *
*[release-please](https://github.com/googleapis/release-please)**.

## [3.0.1](https://github.com/justedlev/spring-boot-firebase-admin/compare/v3.0.0...v3.0.1) (2026-10-24)


### ⚙️ Build

* publish Central deployments automatically ([94afb6a](https://github.com/justedlev/spring-boot-firebase-admin/commit/94afb6a5068a1cd2a2c0c844fa5d7e5228fdded8))

## [3.0.0](https://github.com/justedlev/spring-boot-firebase-admin/compare/46bafc9...v3.0.0) (2026-10-13)


### ⚠ BREAKING CHANGES

* FirebaseProperties connectTimeout/readTimeout/ writeTimeout are now java.time.Duration instead of Integer.


### 🚀 Features

* add configuration metadata for per-app properties ([c27eb00](https://github.com/justedlev/spring-boot-firebase-admin/commit/c27eb006eccfce6f10e826626f6172c96fd234d5))
* register service beans for named Firebase apps ([e456ca4](https://github.com/justedlev/spring-boot-firebase-admin/commit/e456ca442782ee7b77f4ae1ca652623ee7b474cc))
* use Duration for connect, read and write timeouts ([bc0d430](https://github.com/justedlev/spring-boot-firebase-admin/commit/bc0d430e3e5fabdbb8391cb4ae33eb0edff0b29b))


### 🐛 Bug Fixes

* compile against Spring Boot 4 PropertyMapper API ([64f4950](https://github.com/justedlev/spring-boot-firebase-admin/commit/64f4950e4435f1db660b19c0500a0297da44d31a))
* delete FirebaseApp instances when the context closes ([f5a304d](https://github.com/justedlev/spring-boot-firebase-admin/commit/f5a304d9960300f0e1b3055988272a4c04559716))
* make service bean conditions and property defaults consistent ([777b8cf](https://github.com/justedlev/spring-boot-firebase-admin/commit/777b8cf9c6f2c4cd5eb30045d4418fafa771bbf2))
* publish the starter as a jar ([194ce09](https://github.com/justedlev/spring-boot-firebase-admin/commit/194ce0966c2e0bd06a49e4adf35e29bb57f75291))
* register auto-configuration under the name Spring Boot loads ([331b7da](https://github.com/justedlev/spring-boot-firebase-admin/commit/331b7dabe56a2bf9ab7a7a3755d8c2f3a5b4d353))
* stop shipping application.yaml in the library jar ([8402b10](https://github.com/justedlev/spring-boot-firebase-admin/commit/8402b10081500e3c0dd8272a5add1482a3d9d795))


### ♻️ Refactoring

* resolve FirebaseOptionsFactory lazily for named apps ([e5c941d](https://github.com/justedlev/spring-boot-firebase-admin/commit/e5c941d445fb45902f08ebd5d6d97243e225bd0d))


### 📚 Documentation

* sync README with the current configuration model ([87823a4](https://github.com/justedlev/spring-boot-firebase-admin/commit/87823a48070231d793c31668d06daaf4f437b20d))
* update README.md ([f01650c](https://github.com/justedlev/spring-boot-firebase-admin/commit/f01650ccab97ee95a5bdf1e5792eaf720a20e1b5))


### 🧪 Tests

* add integration tests against the Firebase Emulator Suite ([a870273](https://github.com/justedlev/spring-boot-firebase-admin/commit/a8702733592339144c5b25da8be4891167362815))
* cover factory overrides and duplicate app names ([03b19d8](https://github.com/justedlev/spring-boot-firebase-admin/commit/03b19d84d955b9cbae8330ff2a38de9899bd2584))


### ⚙️ Build

* **deps-dev:** bump org.apache.maven.plugins:maven-compiler-plugin from 3.14.0 to 3.15.0 ([915086a](https://github.com/justedlev/spring-boot-firebase-admin/commit/915086a76ece80bb74affe396ff14f3723aeb8cf))
* **deps-dev:** bump org.apache.maven.plugins:maven-compiler-plugin from 3.15.0 to 3.16.0 ([fe42377](https://github.com/justedlev/spring-boot-firebase-admin/commit/fe42377400db3ce5cf530c016a9c861b6cb07634))
* **deps-dev:** bump org.apache.maven.plugins:maven-gpg-plugin from 3.2.7 to 3.2.8 ([9de317d](https://github.com/justedlev/spring-boot-firebase-admin/commit/9de317d6ca3d9e95d7542ba7007239e8dd404425))
* **deps-dev:** bump org.apache.maven.plugins:maven-jar-plugin from 3.5.0 to 3.5.1 ([68a774b](https://github.com/justedlev/spring-boot-firebase-admin/commit/68a774b6a76f04b5a73caf10badab0eab31a6ccb))
* **deps-dev:** bump org.apache.maven.plugins:maven-javadoc-plugin from 3.10.0 to 3.12.0 ([e2aa155](https://github.com/justedlev/spring-boot-firebase-admin/commit/e2aa155f6ea86c1ff8dd65df1e7dfae575f68d40))
* **deps-dev:** bump org.apache.maven.plugins:maven-release-plugin from 3.1.1 to 3.3.1 ([ab8d23c](https://github.com/justedlev/spring-boot-firebase-admin/commit/ab8d23ceb58ec7c3b5a4585c4fe0ac68dff611a4))
* **deps-dev:** bump org.sonatype.central:central-publishing-maven-plugin from 0.10.0 to 0.11.0 ([6b95082](https://github.com/justedlev/spring-boot-firebase-admin/commit/6b95082ed5c20f49d274e0d1e6f20cfc9c332a5f))
* **deps:** bump com.google.firebase:firebase-admin from 9.10.0 to 9.11.0 ([d541803](https://github.com/justedlev/spring-boot-firebase-admin/commit/d5418039e304311357248533dd3791271b3b35ff))
* **deps:** bump com.google.firebase:firebase-admin from 9.9.0 to 9.10.0 ([58a7920](https://github.com/justedlev/spring-boot-firebase-admin/commit/58a7920a3bc4c72b4b2ee2bea8b5ca7d6fae1c2a))
* **deps:** bump org.apache.maven:apache-maven from 3.9.14 to 3.9.16 ([b7eae2b](https://github.com/justedlev/spring-boot-firebase-admin/commit/b7eae2ba30f1897182fef8a9bdfac4b043e55708))
* **deps:** bump org.apache.maven:apache-maven from 3.9.16 to 3.10.0 ([1576de2](https://github.com/justedlev/spring-boot-firebase-admin/commit/1576de2a090dd1f2eb76d3e25add4ce85ed8af42))
* **deps:** bump org.springframework.boot:spring-boot-dependencies from 4.1.0 to 4.1.1 ([cee56a6](https://github.com/justedlev/spring-boot-firebase-admin/commit/cee56a63f2a50d75f77756f7bef050f4a0d19202))
* drop the starter's placeholder README ([0aa22e5](https://github.com/justedlev/spring-boot-firebase-admin/commit/0aa22e5e936660be39acf0cd5ebf1c8aca55f4f3))
* mark the starter jar as a Spring Boot dependencies starter ([df41a1b](https://github.com/justedlev/spring-boot-firebase-admin/commit/df41a1b9a5a40175cadf4f849eab775d8a2cde95))
* modernize compiler, Lombok and javadoc configuration ([eaed6f5](https://github.com/justedlev/spring-boot-firebase-admin/commit/eaed6f5b0f664efbc7646e65c1619762e49b943b))

## 3.0.0 — first tag (2026-07-06, never published to Maven Central)


### ⚠ BREAKING CHANGES

* raises the minimum supported Spring Boot to 4.0.x (Spring Framework 7). Compilation against this bump has not been verified in this environment (no Maven/network access); CI (once added) or a local build should validate it before merging.

### 🚀 Features

* upgrade to Spring Boot 4.1 (Spring Framework 7) ([0827e74](https://github.com/justedlev/spring-boot-firebase-admin/commit/0827e74880fcd4a1f7f160163872c7b2f0a059c1))


### 🐛 Bug Fixes

* close credentials InputStream and surface load errors ([592e44f](https://github.com/justedlev/spring-boot-firebase-admin/commit/592e44fe516c1cb7254a708d91e6f881db3ee118))
* close credentials InputStream and surface load errors ([cd7b878](https://github.com/justedlev/spring-boot-firebase-admin/commit/cd7b878d50623f5a1eb7a88f1939bc28af33730e))
* default multi-app name to map key to avoid init collision ([f4c4140](https://github.com/justedlev/spring-boot-firebase-admin/commit/f4c4140142799625b86069157b7694e4b729040f))
* default multi-app name to map key to avoid init collision ([0fc5782](https://github.com/justedlev/spring-boot-firebase-admin/commit/0fc578259c4fdc39d51c9e469294a46c48feb53d))
* merge post-2.0.0 fixes into main ([1c38409](https://github.com/justedlev/spring-boot-firebase-admin/commit/1c384099b64e260cc8d9e179ad2cd0c7d9502b0c))
* revert main's version bookkeeping to 2.0.0 ([6830064](https://github.com/justedlev/spring-boot-firebase-admin/commit/68300648a69a60745d7e9cef9a90c1394e251dda))
* revert main's version bookkeeping to the last real release (2.0.0) ([a4cf202](https://github.com/justedlev/spring-boot-firebase-admin/commit/a4cf2028bc4c3147be9bfb8a0cf9b20852db43f0))
* skip default Firebase app when not configured ([cfa9349](https://github.com/justedlev/spring-boot-firebase-admin/commit/cfa9349ee104ecaa177c3bd8c95b8fbf094ada63))
* skip default Firebase app when not configured ([c353147](https://github.com/justedlev/spring-boot-firebase-admin/commit/c353147cf32f970c97b138ab0fc0e206b2134458))


### 📚 Documentation

* document per-Spring-Boot-generation maintenance branches ([67c5ad4](https://github.com/justedlev/spring-boot-firebase-admin/commit/67c5ad4a867cae0d6168d6f1c71ca95503483539))
* document per-Spring-Boot-generation maintenance branches ([b705920](https://github.com/justedlev/spring-boot-firebase-admin/commit/b705920a1b09f99b5055e7f415075aa625a19213))
* point 2.x.x compatibility entry at the 2.x branch ([4039f9c](https://github.com/justedlev/spring-boot-firebase-admin/commit/4039f9c95efa5ad0a74bfdf98d06f669ccfbb6d0))
* update README with correct links and formatting adjustments ([32d5051](https://github.com/justedlev/spring-boot-firebase-admin/commit/32d50510727919c50cd022eae6e6c91afd4e4c28))

## [2.0.1](https://github.com/justedlev/spring-boot-firebase-admin/compare/v2.0.0...v2.0.1) (2026-07-05)


### 🐛 Bug Fixes

* close credentials InputStream and surface load errors ([592e44f](https://github.com/justedlev/spring-boot-firebase-admin/commit/592e44fe516c1cb7254a708d91e6f881db3ee118))
* close credentials InputStream and surface load errors ([cd7b878](https://github.com/justedlev/spring-boot-firebase-admin/commit/cd7b878d50623f5a1eb7a88f1939bc28af33730e))
* default multi-app name to map key to avoid init collision ([f4c4140](https://github.com/justedlev/spring-boot-firebase-admin/commit/f4c4140142799625b86069157b7694e4b729040f))
* default multi-app name to map key to avoid init collision ([0fc5782](https://github.com/justedlev/spring-boot-firebase-admin/commit/0fc578259c4fdc39d51c9e469294a46c48feb53d))
* merge post-2.0.0 fixes into main ([1c38409](https://github.com/justedlev/spring-boot-firebase-admin/commit/1c384099b64e260cc8d9e179ad2cd0c7d9502b0c))
* skip default Firebase app when not configured ([cfa9349](https://github.com/justedlev/spring-boot-firebase-admin/commit/cfa9349ee104ecaa177c3bd8c95b8fbf094ada63))
* skip default Firebase app when not configured ([c353147](https://github.com/justedlev/spring-boot-firebase-admin/commit/c353147cf32f970c97b138ab0fc0e206b2134458))


### 📚 Documentation

* document per-Spring-Boot-generation maintenance branches ([67c5ad4](https://github.com/justedlev/spring-boot-firebase-admin/commit/67c5ad4a867cae0d6168d6f1c71ca95503483539))
* document per-Spring-Boot-generation maintenance branches ([b705920](https://github.com/justedlev/spring-boot-firebase-admin/commit/b705920a1b09f99b5055e7f415075aa625a19213))
* point 2.x.x compatibility entry at the 2.x branch ([4039f9c](https://github.com/justedlev/spring-boot-firebase-admin/commit/4039f9c95efa5ad0a74bfdf98d06f669ccfbb6d0))
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
