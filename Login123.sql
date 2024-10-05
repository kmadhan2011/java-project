CREATE DATABASE user_db;

USE user_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Insert a sample user (remember to hash the password in real applications)
INSERT INTO users (username, password) VALUES ('testuser', 'password123');
