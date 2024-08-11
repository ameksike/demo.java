FROM openjdk:22-jdk-slim
ARG JAR_FILE=build/libs/com.api.kotlin.ktor-all.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
