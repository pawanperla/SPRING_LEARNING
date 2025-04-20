# SPRING_LEARNING

This repository documents my journey of learning Spring and Spring Boot. It includes concepts, explanations, and practical tips related to Maven, Spring Boot annotations, configurations, dependency injection, bean lifecycle, and more.

---

## What is Maven?

**Apache Maven** is a powerful build automation and project management tool primarily used for Java projects.

### What Maven Does:

1. **Builds Your Project** – `mvn compile`, `mvn package`
2. **Manages Dependencies** – via `pom.xml`
3. **Runs Tests** – `mvn test`
4. **Packages Application** – into `.jar` or `.war` files
5. **Deployment** – if required, via `mvn deploy`

### Common Maven Commands

| Command               | Description                           |
| --------------------- | ------------------------------------- |
| `mvn clean`           | Deletes the `target/` directory       |
| `mvn compile`         | Compiles the source code              |
| `mvn test`            | Runs the test cases                   |
| `mvn package`         | Packages the app into a `.jar`/`.war` |
| `mvn spring-boot:run` | Runs a Spring Boot app directly       |

### About `mvnw` Files

These wrapper files are used to ensure a consistent Maven version across all systems. You can delete them if Maven is already installed locally.

---

## Spring Boot Starter Parent

Using the Spring Boot Starter Parent helps in managing dependencies more efficiently.

- Provides default plugin versions
- Inherits dependency versions (no need to specify them individually)
- Manages Java version, encoding, and more

---

## Actuator

Spring Boot Actuator offers production-ready features to help monitor and manage applications.

### Features:

- Health Checks
- Metrics Collection
- Environment & Configuration Info
- Thread Dumps
- Custom Endpoints

---

## Ways to Run a Maven Project

1. **Via Command Line (JAR Execution)**

   - `mvn package`
   - `cd target`
   - `java -jar <YourApp>.jar`

2. **Using Spring Boot Plugin**

   - `mvn spring-boot:run`

3. **Through IDE**

   - Click the green "Run" icon or use context menu: "Run as Application"

---

## General Spring Boot Configuration

### Application Info

```properties
spring.application.name=MySpringApp
info.app.version=1.0.0
info.app.description=My Spring Boot learning app
```

### Security

```properties
spring.security.user.name=admin
spring.security.user.password=admin123
spring.security.user.roles=ADMIN
```

### CORS

```properties
app.cors.allowed-origins=http://localhost:3000
app.cors.allowed-methods=GET,POST,PUT,DELETE
```

### Server

```properties
server.port=8080
server.servlet.session.timeout=15m
server.servlet.context-path=/api/projects
server.error.include-message=always
```

### Mail

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Profiles

```properties
spring.profiles.active=dev
```

### Logging

```properties
logging.level.root=INFO
logging.level.com.SpringBoot_Learning=DEBUG
logging.level.org.springframework.web=DEBUG
logging.file.name=SpringBoot_Learning.log
logging.file.path=/logs
logging.pattern.file=%d{yyyy-MM-dd} %p %c{1} - %m%n
logging.file.max-size=10MB
logging.file.max-history=30
logging.file.total-size-cap=1GB
logging.file.clean-history-on-start=true
```

---

## Key Spring Boot Annotations

### `@SpringBootApplication`

Combines:

- `@Configuration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

### `@ComponentScan`

Scans the specified packages for Spring components.

```java
@SpringBootApplication(scanBasePackages = {"com.package1", "com.package2"})
```

### Annotation Summary

| Annotation        | Purpose                          |
| ----------------- | -------------------------------- |
| `@Component`      | Generic Spring-managed component |
| `@Service`        | Business logic component         |
| `@Repository`     | Data access component            |
| `@Controller`     | MVC controller                   |
| `@RestController` | REST API controller              |

---

## Dependency Injection & Bean Management

### AutoWiring

- Spring injects dependencies into components using `@Autowired`
- Automatically detects implementations and injects accordingly

### `@Qualifier` vs `@Primary`

- Use `@Qualifier("beanName")` to specify the desired bean
- Use `@Primary` to mark a default bean (but `@Qualifier` takes precedence)

### Custom Bean Example

```java
@Component("battingCoach")
public class CricketCoach implements Coach {}
```

---

## Lazy Initialization

- Default behavior: **Eager** (at startup)
- To enable lazy loading:
  - Globally: `spring.main.lazy-initialization=true`
  - Per class: Use `@Lazy`

---

## Bean Scopes

| Scope       | Description                        | Annotation                                        |
| ----------- | ---------------------------------- | ------------------------------------------------- |
| Singleton   | Single instance per Spring context | `@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)` |
| Prototype   | New instance every time requested  | `@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)` |
| Request     | One per HTTP request               | `@Scope(WebApplicationContext.SCOPE_REQUEST)`     |
| Session     | One per HTTP session               | `@Scope(WebApplicationContext.SCOPE_SESSION)`     |
| Application | One per application lifecycle      | `@Scope(WebApplicationContext.SCOPE_APPLICATION)` |

---

## Bean Lifecycle

Lifecycle Phases:

1. Instantiation (Constructor)
2. Dependency Injection
3. `@PostConstruct`
4. `afterPropertiesSet()` (if using `InitializingBean`)
5. Bean ready to use
6. `@PreDestroy`
7. `destroy()` (if using `DisposableBean`)

> **Note:** `@PreDestroy` and `destroy()` are not called for **prototype** beans. You must manage their cleanup manually.

---

## Bean Configuration

If a class is not marked with `@Component`, you can still register it as a bean manually using a configuration class:

```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService();
    }
}
```

This allows Spring to manage and inject it wherever required.
