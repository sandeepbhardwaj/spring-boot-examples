Spring Boot Starter Parent - Provides all the dependencies version and java version
Spring Boot Starter Web - Provides actual dependencies for starter web.
DevTools - Provides a faster way to deploy changes without restart the server.

@SpringBootApplication
@ResponseBody annotation


Spring Web MVC
--------------------------------------------
spring.mvc.view.prefix: /WEB-INF/jsp/
spring.mvc.view.suffix: .jsp

<!-- To enable jsp support -->
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
	<scope>provided</scope>
</dependency>


@RequestParam and ModelMap
--------------------------------------------
Model : Model is used to pass data from Controller to View (jsp).