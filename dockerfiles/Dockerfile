# Use the official MySQL image from Docker Hub
FROM mysql:8.0

# Environment variables
ENV MYSQL_DATABASE=security_summary_db
ENV MYSQL_ROOT_PASSWORD=my-secret-pw

# Set the working directory
WORKDIR /docker-entrypoint-initdb.d

# Add a database setup script
COPY ./sql-scripts/ /docker-entrypoint-initdb.d/

# Expose port 3306 for the MySQL service
EXPOSE 3306
