CREATE TABLE br_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    username VARCHAR(255) NOT NULL,
    encrypt_password INT NOT NULL
);