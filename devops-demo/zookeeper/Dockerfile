# Use openjdk 11 as a base image
FROM openjdk:11-jre-slim

# Set Label
LABEL maintainer "kylinsoong.1214@gmail.com"

# Set the working directory to /app
WORKDIR /app

# Copy the runable jar into the container at /app
ADD target/devops-loan-zookeeper-1.0.jar /app

EXPOSE 2181

# Run  when the container launches
CMD ["java", "-jar", "devops-loan-zookeeper-1.0.jar"]
