# Use openjdk 13 as a base image
FROM openjdk:13

# Set Label
LABEL maintainer "kylinsoong.1214@gmail.com"

# Set the working directory to /app
WORKDIR /app

# Copy the runable jar into the container at /app
ADD target/dubbo-user-service-provider-0.0.1.jar /app

# Make port 20880 available to the world outside this container
EXPOSE 20880

# Run  when the container launches
CMD ["java", "-jar", "dubbo-user-service-provider-0.0.1.jar"]
