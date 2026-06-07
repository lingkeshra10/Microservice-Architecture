-- Add indexes
CREATE INDEX idx_email_host ON br_email(host);
CREATE INDEX idx_email_priority ON br_email(priority);
