# Stage 1: Build the application
# Stage 1: Build the Java application using Maven
FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create a smaller image using Eclipse Temurin 17 and copy the JAR from the build stage
FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=build /app/target/sample.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

