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

## Contributors
[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/0)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/0)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/1)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/1)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/2)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/2)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/3)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/3)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/4)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/4)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/5)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/5)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/6)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/6)[![](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/images/7)](https://sourcerer.io/fame/marcosvidolin/ciandt-dev/it-java-api-skeleton/links/7)