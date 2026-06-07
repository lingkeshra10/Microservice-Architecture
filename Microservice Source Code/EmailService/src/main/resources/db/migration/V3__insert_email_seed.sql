-- Default seed data
INSERT INTO br_email (
    id, host, port, sender, username, password,
    priority, require_authentication, debug_mode,
    ssl_enable, tls_enable, enable
)
VALUES (
    '1',
    'smtp.example.com',
    587,
    'noreply@example.com',
    'user',
    'password',
    1,
    1,
    0,
    1,
    1,
    1
);