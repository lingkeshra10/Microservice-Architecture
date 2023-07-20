package com.lingkesh.microservice.EmailService.modal;

public class EmailAttachmentModal {

    String userId;
    private String username;
    private String email;
    private String emailNotificationType;
    private String attachment;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailNotificationType() {
        return emailNotificationType;
    }

    public void setEmailNotificationType(String emailNotificationType) {
        this.emailNotificationType = emailNotificationType;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
