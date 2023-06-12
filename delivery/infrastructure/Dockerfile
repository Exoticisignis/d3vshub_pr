# Base image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy JAR file to container
COPY ./target/App.jar /app

# Expose port
EXPOSE 8080

# Start application
CMD ["java", "-jar", "App.jar"]
