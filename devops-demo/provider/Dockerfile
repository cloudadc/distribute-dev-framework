# Use openjdk 11 as a base image
FROM openjdk:11-jre-slim

# Set Label
LABEL maintainer "kylinsoong.1214@gmail.com"

# Set the working directory to /app
WORKDIR /app

# Copy the runable jar into the container at /app
ADD target/devops-loan-provider-1.0.jar /app

# Make port 20880 available to the world outside this container
EXPOSE 20880

ENV DUBBO_REGISTRY_PROXY_ADDRESS="zookeeper"
ENV MONGODB_SERVER_ADDRESS="mongodb" 

# Run  when the container launches
CMD ["java", "-jar", "devops-loan-provider-1.0.jar"]
