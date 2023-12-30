# Use the official OpenJDK base image
FROM openjdk:17-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/ecommerce-0.0.1-SNAPSHOT.jar app.jar

# Copy the service account JSON key file into the container
COPY target/ecommerce-inm429.json /app/service-account-key.json

# Set the GOOGLE_APPLICATION_CREDENTIALS environment variable
ENV GOOGLE_APPLICATION_CREDENTIALS=/app/service-account-key.json

# Expose the port your application will run on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "app.jar"]