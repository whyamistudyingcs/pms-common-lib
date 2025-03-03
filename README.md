# PMS Common Library

A shared library containing common entities, DTOs, and repositories for the PMS (Portfolio Management System) project.

## Project Structure

```
simTrade/
├── pom.xml                 # Parent POM
├── pms-common/            # Shared library
│   ├── pom.xml
│   └── src/
│       └── main/
│           └── java/
│               └── com/
│                   └── fdm/
│                       └── pmscommon/
│                           ├── entities/
│                           ├── dto/
│                           └── repositories/
├── microservice1/         # Client service
│   └── pom.xml
└── microservice2/         # Client service
    └── pom.xml
```

## Setup

### Parent POM Configuration

```xml
// filepath: /Users/dameningen/Desktop/FDM_training/simTrade/pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.2</version>
        <relativePath/>
    </parent>

    <groupId>com.fdm</groupId>
    <artifactId>pms-parent</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>pom</packaging>
    <name>pms-parent</name>
    <description>Parent POM for PMS Project</description>

    <properties>
        <java.version>17</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
        <hibernate.version>6.4.1.Final</hibernate.version>
    </properties>

    <modules>
        <module>pms-common</module>
        <module>pmsuibackend</module>
    </modules>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>com.fdm</groupId>
                <artifactId>pms-common</artifactId>
                <version>${project.version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <pluginManagement>
            <plugins>
                <!-- Spring Boot Maven Plugin -->
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <configuration>
                        <excludes>
                            <exclude>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok</artifactId>
                            </exclude>
                        </excludes>
                    </configuration>
                </plugin>

                <!-- Maven Compiler Plugin -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.11.0</version>
                    <configuration>
                        <source>${java.version}</source>
                        <target>${java.version}</target>
                        <annotationProcessorPaths>
                            <path>
                                <groupId>org.projectlombok</groupId>
                                <artifactId>lombok</artifactId>
                                <version>${lombok.version}</version>
                            </path>
                        </annotationProcessorPaths>
                    </configuration>
                </plugin>

                <!-- Spotless Plugin for code formatting -->
                <plugin>
                    <groupId>com.diffplug.spotless</groupId>
                    <artifactId>spotless-maven-plugin</artifactId>
                    <version>2.40.0</version>
                    <configuration>
                        <java>
                            <googleJavaFormat>
                                <version>1.17.0</version>
                                <style>GOOGLE</style>
                            </googleJavaFormat>
                            <removeUnusedImports/>
                        </java>
                    </configuration>
                </plugin>

            </plugins>
        </pluginManagement>
    </build>
</project>
```

### Library POM Configuration

```xml
// filepath: /Users/dameningen/Desktop/FDM_training/simTrade/pms-common/pom.xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>com.fdm</groupId>
        <artifactId>pms-parent</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>pms-common</artifactId>
    <name>pms-common</name>
    <description>Common library for PMS</description>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>
```

### Client Service Configuration

```xml
// Example microservice POM
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <modelVersion>4.0.0</modelVersion>
    
    <parent>
        <groupId>com.fdm</groupId>
        <artifactId>pms-parent</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>microservice1</artifactId>
    
    <dependencies>
        <dependency>
            <groupId>com.fdm</groupId>
            <artifactId>pms-common</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
</project>
```

## Usage in Client Services

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