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
