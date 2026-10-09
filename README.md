# octiq-java-gradle-nowrapper-11

> Synthetic fixture for testing Octiq's GitHub import of Java projects. Not a real application.

## Scenario

A Gradle (Groovy DSL) project with NO wrapper at all, so the build runs the `gradle` binary from the official image. The Java version is declared as `sourceCompatibility = JavaVersion.VERSION_11` / `targetCompatibility = JavaVersion.VERSION_11` inside a `java { }` block.

## What this exercises

- The `JavaVersion.VERSION_<n>` branch of version detection, which is a different branch from `JavaLanguageVersion.of(n)` and `jvmToolchain(n)` used by the other Gradle fixtures
- Gradle build with no wrapper (the `gradle` binary from the official image is used)
- It is the only fixture that builds on Java 11, so it covers the lowest supported JDK and the `gradle:8-jdk11` image

## Expected result on import

| Field | Expected |
| --- | --- |
| stack | `java` |
| build tool | `gradle` |
| Java version | `11` |
| image | `gradle:8-jdk11` |
| framework | `java` |
| modules | `[]` |
| final phase | `ready` |
| build green | `true` |

A detected version other than 11 means the `JavaVersion.VERSION_<n>` detection regressed.

## Layout

```
build.gradle
settings.gradle
src/main/java/com/octiq/fixture/Legacy.java
```
