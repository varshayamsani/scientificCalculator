# Use lightweight Java 17 base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy built JAR into container
COPY target/ScientificCalculator-1.0-SNAPSHOT.jar app.jar

# Run the calculator automatically
ENTRYPOINT ["java", "-jar", "app.jar"]
