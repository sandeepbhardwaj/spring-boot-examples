# Spring Boot Configuration


## Build and run using command line
**Run from command line**

```bash
$> mvn spring-boot:run

$> ./gradlew bootRun
```

**Build using command line**

```
$> mvn package

$>./gradlew build
```

**Build and run from command line**

```bash
./gradlew build && java -jar build/libs/spring-boot-0.1.0.jar

mvn package && java -jar target/spring-boot-0.1.0.jar
```

## Auto Configuration
* @EnableAutoConfiguration loads /META-INF/spring.factories
* spring.factories declares @Configuration classes
* Each @Configuration is @conditional

## Map properties to POJO
* @ConfigurationProperties
* Type Safe
* Can be validate with @Valid
	
**Overriding properties from outside**
``java -Dconfiguration.projectName=SPRING -jar spring-boot-configuration.jar``
	
	
## spring-boot-actuator
http://localhost:8080/configprops

## Relax Binding

```java
@Component
@ConfigurationProperties(prefix="person")
public class ConnectionSettings{

	private String firstName;
}
```

``person.firstName, person.first-name, PERSON_FIRST_NAME`` all three are valid mapping to above code.

## Support multiple environments using Spring Profiles
* Label beans as belonging to different environments(dev, qa, cloud, etc.)
* Spring boot also loads ``application.profile.properties``

```java
@Configuration
public class DataSourceConfig {

@Bean
@Profile("dev")
DataSource dev() { return .... ;}

@Bean
@Profile("cloud")
DataSource cloud() { return .... ;}

}
```

**load profile using command line argument**

```bash
java -Dspring.profiles.active=dev -jar spring-boot-configuration.jar
```







