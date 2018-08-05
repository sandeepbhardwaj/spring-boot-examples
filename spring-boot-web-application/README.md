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

## Implementing Server Side Validation
- Command Bean or Form Backing Bean
    * Add Validation
    * Use Validation on Controller
    * Display Errors in View

- Command Bean
    * Controller
    * View - Spring Form Tags

```
@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

	if (result.hasErrors()) {
		return "todo";
	}

	service.addTodo((String) model.get("name"), todo.getDesc(), new Date(), false);
	return "redirect:/list-todos";
}
```

```
<form:form method="post" modelAttribute="todo">
<form:errors path="desc" cssClass="text-warning" />
```

## InitBinder
```
@InitBinder
protected void initBinder(WebDataBinder binder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(
			dateFormat, false));
}
```

```
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy" />
```

### JSP Fragments


## Spring boot security starter

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

```
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
		  UserDetails userDetails=User.withUsername("sandeep").password("{noop}dummy").roles("USER").build();

        auth.inMemoryAuthentication().withUser(userDetails);
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
                .formLogin();
    }
}
```

## Access user in spring security
```
private String getLoggedInUserName() {
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	if (principal instanceof UserDetails)
		return ((UserDetails) principal).getUsername();

	return principal.toString();
}
```

## Implement logout in spring security
```
@RequestMapping(value = "/logout", method = RequestMethod.GET)
public String logout(HttpServletRequest request,
		HttpServletResponse response) {
	
	Authentication authentication = SecurityContextHolder.getContext()
			.getAuthentication();
	
	if (authentication != null) {
		new SecurityContextLogoutHandler().logout(request, response,
				authentication);
	}

	return "redirect:/";
}
```

## Exception Handling
```
@Controller("error")
public class ExceptionController {

    private Log logger = LogFactory.getLog(ExceptionController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
```
