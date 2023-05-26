# Use an official maven image with JDK 17 as a parent image
FROM maven:3.8.4-openjdk-17-slim as build

# Set the working directory in the image to /app
WORKDIR /app

# Add the pom.xml file to /app in the image
COPY ./pom.xml ./pom.xml

# Add the src directory to /app/src in the image
COPY ./src ./src

# Package the application
RUN mvn package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/microservice-0.0.1-SNAPSHOT.jar /usr/local/lib/microservice.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/microservice.jar"]
