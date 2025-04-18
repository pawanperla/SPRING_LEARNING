# SPRING_LEARNING

This is a repo that tracks my spring learnings

## mvnw files

These files are deleted because it is not needed when working. Basically, these files are there in your directory to install latest maven version and to run the project. When you have maven installed locally on your computer it is not needed to add these files in the directory. Thats why deleted those two files.

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
