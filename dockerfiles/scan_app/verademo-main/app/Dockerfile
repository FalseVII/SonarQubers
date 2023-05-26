# Use the sonarsource/sonar-scanner-cli Docker image as a base image
FROM sonarsource/sonar-scanner-cli:latest

# Set the working directory in the image
WORKDIR /app

# Install OpenJDK 17, if available in the base image's package manager.
RUN apk --no-cache add openjdk17-jdk

# Set JAVA_HOME to the OpenJDK installation
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk

# Copy the application source code to the image
COPY . .


# Set the entrypoint command for running the Sonar Scanner
ENTRYPOINT ["sonar-scanner", "-Dsonar.projectKey=vuln_project", "-Dsonar.sources=./src", "-Dsonar.java.binaries=./target/classes"]

