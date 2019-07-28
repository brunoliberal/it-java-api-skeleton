# it-java-api-skeleton
CI&amp;T IT's default Java project skeleton for Microservices and APIs

## Pre-requisites

- Java >= 1.8
- Gradle >= 2
- [Lombok](https://projectlombok.org/download.html)

## Profiles

To run the application in a specific profile you must set the argument in VM options:
```java
-Dspring.profiles.active=dev
```

## Docker
```shell
docker build --build-arg profile=<PROFILE> .
```
```shell
docker build --build-arg profile=local .
```
Arguments:
* profile (Default = notset)


## Dependency Check
Run the following comand and check the report: "build/reports/dependency-check-report.html"

```shell
./gradlew dependencyCheckAnalyze --info
```
