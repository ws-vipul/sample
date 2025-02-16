# Stage 1: Build the application
FROM maven:3.8-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files (pom.xml, etc.)
COPY pom.xml .

# Download dependencies (to leverage Docker cache during future builds)
RUN mvn dependency:go-offline

# Copy the entire project into the container
COPY . .

# Build the Spring Boot application and package it as a jar file
RUN mvn clean package -DskipTests

# Stage 2: Set up the runtime environment
FROM openjdk:17-jdk-slim

# Expose port 8080 (default Spring Boot port)
EXPOSE 8080

# Copy the JAR file from the build stage to the runtime image
COPY --from=build /app/target/sample.jar app.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
