-- File name: /sql-scripts/init.sql
ALTER USER 'yourusername'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
CREATE DATABASE IF NOT EXISTS security_summary_db;
USE security_summary_db;
