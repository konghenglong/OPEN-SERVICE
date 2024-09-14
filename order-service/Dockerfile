# Use OpenJDK as the base image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file and SSL certificates from the build context
COPY target/order-service.jar /app/order-service.jar
COPY external/wildcard.crt /etc/ssl/certs/wildcard.crt
COPY external/wildcard.key /etc/ssl/certs/wildcard.key

# Import the SSL certificate into the Java trust store
RUN keytool -import -alias prod-cert \
    -file /etc/ssl/certs/wildcard.crt \
    -keystore $JAVA_HOME/lib/security/cacerts \
    -storepass changeit -noprompt

# Expose the HTTPS port
EXPOSE 9001

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/order-service.jar"]
