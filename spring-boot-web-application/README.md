- Spring Boot Starter Parent - Provides all the dependencies version and java version
- Spring Boot Starter Web - Provides actual dependencies for starter web.
- DevTools - Provides a faster way to deploy changes without restart the server.
- @SpringBootApplication
- @ResponseBody annotation

## Spring Web MVC
```
spring.mvc.view.prefix: /WEB-INF/jsp/
spring.mvc.view.suffix: .jsp
```

```
<!-- To enable jsp support -->
<dependency>
	<groupId>org.apache.tomcat.embed</groupId>
	<artifactId>tomcat-embed-jasper</artifactId>
	<scope>provided</scope>
</dependency>
```

## @RequestParam and ModelMap
- Model : Model is used to pass data from Controller to View (jsp).

## Spring MVC Request Flow
- DispatcherServlet receives HTTP Request.
- DispatcherServlet identifies the right Controller based on the URL.
- Controller executes Business Logic.
- Controller returns a) Model b) View Name Back to DispatcherServlet.
- DispatcherServlet identifies the correct view (ViewResolver).
- DispatcherServlet makes the model available to view and executes it.
- DispatcherServlet returns HTTP Response Back.
- Flow : http://docs.spring.io/spring-framework/docs/2.0.8/reference/images/mvc.png
