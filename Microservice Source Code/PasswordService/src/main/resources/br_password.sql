CREATE TABLE br_password (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    password_user_id BIGINT,
    user_password INT NOT NULL,
    created_date BIGINT NOT NULL
);