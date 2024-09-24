CREATE TABLE br_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    user_phone_number VARCHAR(255),
    username VARCHAR(255) NOT NULL,
    encrypt_password INT NOT NULL,
    status INT NOT NULL,
    unique_id VARCHAR(255),
    application_id VARCHAR(255),
    created_date BIGINT NOT NULL,
    updated_date BIGINT,
    deleted_date BIGINT
);