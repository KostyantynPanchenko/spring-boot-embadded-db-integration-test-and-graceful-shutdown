# Getting Started

### About

Reference usage of H2 and HSQLDB with Spring Boot for running and testing the application. Check how
to:

* configure HSQLDB
* configure H2 for tests
* configure and run integration tests with Failsafe plugin

Graceful shutdown demo: check how to easily configure the web app to stop accepting new requests and
give a change for ongoing requests to complete.

* start the app in your IDE
* open the terminal and `curl localhost:8080/employees`
* stop the app (Ctrl + F2 in case of Intellij IDEA) and quickly (within 1 second) switch back to the
  terminal, see how request is being completed (in your terminal) and afterwards the app shuts
  down (in the app logs)

### Running the tests

* `./mvnw clean test` to run the unit tests
* `./mvnw clean verify` to run the integration tests

### Core config params

```
# configure the datasource
spring.datasource.username=sa
spring.datasource.password=password
spring.datasource.url=jdbc:hsqldb:mem:integration

# configure some JPA properties
spring.jpa.open-in-view=false
spring.jpa.database=hsql
spring.jpa.hibernate.ddl-auto=none

# configure db initialization
spring.sql.init.mode=embedded
spring.sql.init.platform=hsqldb
spring.sql.init.schema-locations=classpath:schema-hsqldb.sql
spring.sql.init.data-locations=classpath:data-hsqldb.sql
```
