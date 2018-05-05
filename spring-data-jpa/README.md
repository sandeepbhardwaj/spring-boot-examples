# Spring Data JPA

## Data in a microservice world
* Database is not a synchronized layer
* Database is not shared across microservices
* Database belong to a microservice
* If need data from a different database, call its microservice

## Repository Interface
* CrudRepository (create, read, update, delete)
* Paging and sorting support
* Custom finder method support

```java
Iterable<Car> findByMake(String make)
select * from car where make="HONDA"

findByLastnameAndFirstname
findByAgeLessThan
findByFirstnameLikeIgnoringCase
```

## Dependency
```xml
spring-boot-starter-data-jpa
```

