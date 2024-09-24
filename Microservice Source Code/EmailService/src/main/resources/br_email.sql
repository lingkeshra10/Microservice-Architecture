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

-- Indexes for optimization (optional, if needed)
-- CREATE INDEX idx_email_host ON br_email(host);
-- CREATE INDEX idx_email_priority ON br_email(priority);

-- Insert default data (optional)
INSERT INTO br_email (id, host, port, sender, username, password, priority, require_authentication, debug_mode, ssl_enable, tls_enable, enable)
VALUES ('1', 'smtp.example.com', 587, 'noreply@example.com', 'user', 'password', 1, 1, 0, 1, 1, 1);