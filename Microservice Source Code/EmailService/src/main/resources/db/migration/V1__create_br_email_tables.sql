-- Create table br_email
CREATE TABLE br_email (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    host VARCHAR(255) NOT NULL,
    port INT,
    sender VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    priority INT,
    require_authentication INT,
    debug_mode INT,
    ssl_enable INT,
    tls_enable INT,
    enable INT
);

-- Create table br_email_queue
CREATE TABLE br_email_queue (
    id VARCHAR(255) NOT NULL,
    status INT NOT NULL,
    username VARCHAR(255),
    user_email VARCHAR(255),
    email_info TEXT NOT NULL,
    retry_email_fail TEXT,
    created_date BIGINT NOT NULL,
    PRIMARY KEY (id)
);