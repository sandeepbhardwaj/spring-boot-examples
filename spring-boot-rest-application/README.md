## Spring Boot Rest Application

## Spring Boot starter Parent
- Dependency versions
- Java version
- Default Plugins

```
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>2.0.4.RELEASE</version>
	<relativePath/> <!-- lookup parent from repository -->
</parent>
```

## Spring  Boot auto configuration
- spring-boot-autoconfigure.jar
- org.springframework.boot.autoconfigure.web.*
- configure dispatcher-servlet, error page etc etc in case of spring-boot-starter-web

```
 DispatcherServletAutoConfiguration.DispatcherServletConfiguration matched:
      - @ConditionalOnClass found required class 'javax.servlet.ServletRegistration'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)
      - Default DispatcherServlet did not find dispatcher servlet beans (DispatcherServletAutoConfiguration.DefaultDispatcherServletCondition)
      
JacksonAutoConfiguration matched:
      - @ConditionalOnClass found required class 'com.fasterxml.jackson.databind.ObjectMapper'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)
```

## Other Starter Projects
- spring-boot-starter-web-services
- spring-boot-starter-test
- spring-boot-starter-jdbc
- spring-boot-starter-security
- spring-boot-starter-data-jpa
- spring-boot-starter-data-rest
- More at https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-starter

## Message converters
- jackson-databind to convert object to json and json to object.

## Spring Boot Actuator
- /env, /metrics, /trace, /dump, /shutdown, /beans, / autoconfig, /configprops, /mappings

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

## HAL Browser
Provides UI around actuator for easy access of actuator properties
- http://localhost:8080/browser/index.html

```
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-rest-hal-browser</artifactId>
</dependency>
```

## Dynamic Configuration in Sprint Boot
- @Value

```
welcome:
    message: Welcome to your first Spring Boot app!
```
```
@Value("${welcome.message}")
```

- Passing using program argument

```
--welcome.message="Welcome message from program argument"
```
"OR"

```
--spring.config.location=classpath:/default.properties
```
- Using Placeholders

```
--welcome.message="Welcome to ${app.name}"
```

## Spring Profiles
Configure Resources - Databases, Queues, External Services.
Create a property file with profile name

```
application-{profile-name}.properties
```
- Adding property in property/yaml file

```
spring.profiles.active=dev|qa|prod
```

- VM arguments

```
-Dspring.profiles.active=prod
```

- Using @Profile("prod") on bean

```
@Profile("dev")
```