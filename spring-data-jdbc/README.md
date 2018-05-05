# Spring Data Jdbc

```java
private final JdbcTemplate template;

@Autowired
public CarRepository(JdbcTemplate template) {
	this.template = template;
}
```


```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/cars?autoReconnect=true&useSSL=false
    username: root
    password: password
    initialize: false
```
