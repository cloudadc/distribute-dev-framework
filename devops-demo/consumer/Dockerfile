# Use openjdk 11 as a base image
FROM openjdk:11-jre-slim

# Set Label
LABEL maintainer "kylinsoong.1214@gmail.com"

# Set the working directory to /app
WORKDIR /app

# Copy the runable jar into the container at /app
ADD target/devops-loan-consumer-1.0.jar /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

ENV DUBBO_REGISTRY_PROXY_ADDRESS="zookeeper"

# Run  when the container launches
CMD ["java", "-jar", "devops-loan-consumer-1.0.jar"]
