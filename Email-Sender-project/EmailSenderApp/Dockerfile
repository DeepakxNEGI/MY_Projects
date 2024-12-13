# Use OpenJDK 22 base image
FROM openjdk:22-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build JAR file into the container
COPY target/EmailSenderApp-0.0.1-SNAPSHOT.jar EmailSenderApp.jar

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "EmailSenderApp.jar"]