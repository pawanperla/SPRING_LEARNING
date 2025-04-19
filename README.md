# SPRING_LEARNING

This is a repo that tracks my spring learnings

## What is Maven?

Apache Maven is a build automation and project management tool primarily used for Java projects.

### What it does:

1. Builds your project (mvn compile, mvn package, etc.)
2. Manages dependencies (like Spring Boot, JUnit, etc.) via a pom.xml file
3. Runs tests (mvn test)
4. Packages your app into a JAR/WAR (mvn package)
5. Deploys it, if needed (mvn deploy)

### Common Maven Commands Used

#### Command --> Description

1. mvn clean --> Deletes target/ directory
2. mvn compile --> Compiles source code
3. mvn test --> Runs tests
4. mvn package --> Packages app into .jar or .war
5. mvn spring-boot:run Runs a Spring Boot app directly

## mvnw files

These files are deleted because it is not needed when working.
Basically, these files are there in your directory to install latest maven version and to run the project. Thus no need to have maven installed or present in your path.
When you have maven installed locally on your computer it is not needed to add these files in the directory. Thats why deleted those two files.

## spring boot starter parents

Here if we mention the version, the dependencies will inherit the version from the parent. So, no need to list individual versions. It is great for maintainence.

The starter parent gets you -->

1.  Java Version, UTF encoding etc
2.  Default version of the springboot plugin
3.  Dependency Management
    1.  Use Java Version on parent only
    2.  for dependencies inherit the parent version

## Actuator

Spring Boot Actuator provides production-ready features to help you monitor and manage your application. It includes a set of built-in endpoints that allow you to gather metrics, view application health, and interact with your application.

1. **Health Checks**: Monitor the health of your application.
2. **Metrics**: Collect and view application metrics like memory usage, active threads, and more.
3. **Environment Information**: Access details about the application's environment and configuration.
4. **Thread Dump**: Analyze thread dumps for debugging.
5. **Custom Endpoints**: Create your own endpoints for specific needs.

## Different Ways to RUN a maven project

Three Ways are there to RUN a MAVEN project

1. RUN the jar file manually in command line --->
   1. run : mvn package (this will create a jar file of the project in ./target)
   2. then run : cd target (go to the target folder)
   3. then run : java -jar {Project_Name}.jar (here it is SpringBoot_Learning-0.0.1-SNAPSHOT.jar)
2. make sure that you are in main project directory --->
   1. run : mvn spring-boot:run
3. Just click the run icon in IDE or right click --> run as application on any java file of the project.

## General SpringBoot Configuration Settings

1. App Name and Version
   1. spring.application.name=MySpringApp
   2. info.app.version=1.0.0
   3. info.app.description=My Spring Boot learning app
2. SPRING SECURITY
   1. spring.security.user.name=admin
   2. spring.security.user.password=admin123
   3. spring.security.user.roles=ADMIN
3. CORS CONFIGURATION
   1. app.cors.allowed-origins=http://localhost:3000
   2. app.cors.allowed-methods=GET,POST,PUT,DELETE
4. SERVER
   1. server.port=8080
   2. server.servlet.session.timeout=15m
   3. server.servlet.context-path=/api/projects
   4. server.error.include-message=always
5. MAIL SETTINGS
   1. spring.mail.host=smtp.gmail.com
   2. spring.mail.port=587
   3. spring.mail.username=your-email@gmail.com
   4. spring.mail.password=your-password
   5. spring.mail.properties.mail.smtp.auth=true
   6. spring.mail.properties.mail.smtp.starttls.enable=true
6. SPRING PROFILES
   1. spring.profiles.active=dev
7. LOGGING
   1. logging.level.root=INFO
   2. logging.level.com.SpringBoot_Learning=DEBUG
   3. logging.level.org.springframework.web=DEBUG
   4. logging.file.name=SpringBoot_Learning.log
   5. logging.file.path={Actual Path}
   6. logging.pattern.file=%d{yyyy-MM-dd} %p %c{1} - %m%n
   7. logging.file.max-size=10MB
   8. logging.file.max-history=30
   9. logging.file.total-size-cap=1GB
   10. logging.file.clean-history-on-start=true

## What is @SpringBootApplication

@SpringBootApplication is a convenience annotation that combines three annotations in one:

1. @Configuration

   1. Marks the class as a source of bean definitions.
   2. Equivalent to an XML-based Spring configuration file.

2. @EnableAutoConfiguration

   1. Tells Spring Boot to automatically configure beans based on the classpath and your application properties.
   2. Example: If Spring sees spring-boot-starter-web, it configures Tomcat, DispatcherServlet, etc.

3. @ComponentScan
   1. Tells Spring to scan for components (like @Component, @Service, @Repository, and @Controller) in the current package and sub-packages.

## What is ApplicationContext

ApplicationContext is the central interface in Spring for providing configuration information to the application.

1. Think of it like a container or a brain that:
2. Creates and manages all your beans
3. Handles dependency injection
4. Manages the complete life cycle of beans
5. Provides built-in support for features like i18n (internationalization), event propagation, etc.

In Simpler Terms :

1. ApplicationContext = Spring’s container
2. It manages all your app’s beans & dependencies
3. You can fetch, inspect, and control beans using it

## What is Component Scanning?

Component scanning is the process by which Spring automatically detects and registers beans (classes annotated with @Component, @Service, @Repository, @Controller, etc.) into the ApplicationContext — so you don’t have to manually declare them using @Bean.

Component Scanning is done by Main Spring Applications @ComponentScan
It only scans packages which are at the same parent level folder for all the service, controller, repository, component.

If you want to Scan different packages..in main spring application should add :
@SpringBootApplication(
scanBasePackages = {Package1 , Package2}
)

### Annotation --> Purpose

1. @Component --> Generic component
2. @Service --> Business logic layer
3. @Repository --> Data access layer
4. @Controller --> Web controller (MVC)
5. @RestController --> REST API controller (Spring Boot)

## AutoWiring

Steps :

1. Spring will scan for @Component files
2. Anyone Implementing an Interface?
3. Let's Inject them

## @Qualifier("{beanName}")

When you specify the @Qualifier("{beanName}")..that component is scanned and AutoWired and dependency is Injected

By default, the bean name is:
The camelCase version of the class name if you annotate it with @Component, @Service, @Repository, or @Controller without specifying a name.

### Custom beanName

@Component("battingCoach")
public class CricketCoach implements Coach { }

here the bean name is battingCoach

## @Primary

If a component is annotated with @Primary it will be injected instead of any other components which implements the interface.

But, Adding @Qualifier("coach") has more priority eventhough @Primary is used

Multiple Components with @Primary will throw an error

## What is Lazy Initialization in Spring?

Lazy Initialization means Spring will create the bean only when it’s needed for the first time, not at application startup.

By default, Spring Boot eagerly creates all singleton beans at startup, which might:

1. Slow down startup time
2. Waste resources if some beans are never used

Key Concepts & Points

1. Default Behavior = Eager Initialization
2. Enabling Lazy Initialization Globally --> spring.main.lazy-initialization=true
3. Lazy Initialization at Class Level --> Use @Lazy annotation

## What is Bean Scope?

Bean Scope defines how many instances of a bean Spring creates and how long those instances live. By default, Spring beans are singleton, but Spring provides multiple scopes for different use cases.

### Common Bean Scopes in Spring

1. Singleton
   1. Only one instance per Spring container
   2. Created during application startup (unless lazy-loaded)
   3. @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) use this annotation. It is deafult scope
2. Prototype
   1. A new instance is created every time the bean is requested.
   2. Good for lightweight, stateful beans.
   3. @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) use this annotation
3. Request
   1. One bean per HTTP request
   2. Useful for request-scoped data
   3. @Scope(WebApplicationContext.SCOPE_REQUEST)
4. Session
   1. One bean per HTTP session
   2. Perfect for user login/session-specific data
   3. @Scope(WebApplicationContext.SCOPE_SESSION)
5. Application
   1. One bean for the entire ServletContext
   2. Shared across all requests and sessions
   3. @Scope(WebApplicationContext.APPLICATION)
