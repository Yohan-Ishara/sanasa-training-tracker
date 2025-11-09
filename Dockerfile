# ---------- Build Stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy only pom.xml first (for dependency caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Define environment variables
ENV PORT=8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
