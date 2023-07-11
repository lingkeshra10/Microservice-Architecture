package com.lingkesh.microservice.passwordservice.modal;

public class RegisterPasswordModal {

    private Long userId;
    private String username;
    private int newPassword;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(int newPassword) {
        this.newPassword = newPassword;
    }
}
