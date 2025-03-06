# PMS Common Library

A shared library containing common entities, DTOs, and repositories for the PMS (Portfolio Management System) project.


## Project Structure

```
── pms-common/            # Shared library
│   ├── pom.xml
│   └── src/
│       └── main/
│           └── java/
│               └── com/
│                   └── fdm/
│                       └── pmscommon/
│                           ├── entities/     # Domain model entities
│                           ├── dto/          # Data Transfer Objects
│                           └── repositories/ # Data access layer
│                           └── config/       # RabbitMQ configuration
```

## Package Details

### RabbitMQ configuration hints: 
- Exchange: An entity in RabbitMQ where messages are sent. It routes messages to one or more queues based on the exchange type and bindings. Types include Direct, Fanout, Topic, and Headers exchanges.

- Queue: A buffer that stores messages until they are consumed by applications. Queues can be durable or transient. Durable queues persist messages to disk and survive broker restarts.

- Binding: A link between an exchange and a queue. It specifies how messages are routed from the exchange to the queue using a binding key.

- Routing key: An attribute of a message that determines which queues it should be routed to. It is compared with the binding key of queues.

- Caveat: Message lost handling and node failure handling are not implemented yet. Consider implementing durable queues, publisher confirms, dead letter exchanges (DLX), and clustering to handle these scenarios. Check out for future enhancement (https://www.rabbitmq.com/docs/partitions).

## Setup


### Client Service Configuration

```xml
// Example microservice POM
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <modelVersion>4.0.0</modelVersion>
    
    .... Other code .....
    <artifactId>microservice1</artifactId>
    
    <dependencies>
        <dependency>
			<groupId>com.fdm</groupId>
			<artifactId>pms-common</artifactId>
			<version>0.0.1-SNAPSHOT</version>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-data-jpa</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

        ..... Other dependencies ....
    </dependencies>
</project>
```

### Usage in Client Services

Enable component scanning in your Spring Boot application:

```java
// filepath: /microservice1/src/main/java/com/fdm/microservice1/Microservice1Application.java
@SpringBootApplication
@ComponentScan(basePackages = {"com.fdm.microservice1", "com.fdm.pmscommon"})
@EntityScan(basePackages = {"com.fdm.pmscommon.entities"})
@EnableJpaRepositories(basePackages = {"com.fdm.pmscommon.repositories"})
public class Microservice1Application {
    public static void main(String[] args) {
        SpringApplication.run(Microservice1Application.class, args);
    }
}
```

## Building and Installing

To make the library available for other microservices:

```bash
cd pms-common
mvn clean install
```

This will install the library to your local Maven repository (~/.m2).

```bash
# Install the common library
cd /Users/dameningen/Desktop/FDM_training/simTrade
mvn clean install

# Run specific microservice
cd microservice1
mvn spring-boot:run
```

## Notes
- Ensure all microservices use compatible versions of Spring Boot
- The common library should contain only shared code (entities, DTOs, repositories)
- Avoid circular dependencies between modules
- Use proper package scanning to include common components