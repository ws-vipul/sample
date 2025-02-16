# Stage 1: Build the application
FROM maven:3-eclipse-temurin-17
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-alpine
COPY --from=build /app/target/sample.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
