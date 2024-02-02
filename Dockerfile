# Use the official OpenJDK 17 as the base image as build project gradle
FROM openjdk:17-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the application files to the container
COPY . .

# Build the Spring Boot application
RUN ./gradlew clean build

# Use the official OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
RUN mkdir /app

# Expose the default Spring Boot port
EXPOSE 8080

# Copy the application jar to the container
COPY --from=build /app/build/libs/*.jar /app/crypto.jar

# Set the default command to run the Spring Boot application
CMD ["java", "-jar", "/app/crypto.jar"]