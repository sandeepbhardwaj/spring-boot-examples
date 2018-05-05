## Spring Cloud Configuration Server
* Provides centralized, journaled, and secure configuration values.
* Powered by Git repository (GitHub, local etc)
* Acts as a **proxy** for configuration files in Git repository.

```yml
spring:
  cloud:
    config: 
      server:
        git:
          uri: https://github.com/sandeepbhardwaj/spring-cloud-configs
```

**Url**

```
http://localhost:8888/config-client/master
```
