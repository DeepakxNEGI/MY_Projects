# Use an official OpenJDK runtime as the base image
FROM openjdk:22-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY . .

# Build the application using Maven
RUN ./mvnw clean package -DskipTests

# Copy the built JAR file to the final image
COPY target/EmailSenderApp-0.0.1-SNAPSHOT.jar EmailSenderApp.jar

# Expose the port your application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "EmailSenderApp.jar"]