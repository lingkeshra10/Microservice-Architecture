package com.lingkesh.microservice.userservice.kafka.modal;

public class EmailModal {

    String userId;
    private String username;
    private String email;
    private String emailNotificationType;

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
}
