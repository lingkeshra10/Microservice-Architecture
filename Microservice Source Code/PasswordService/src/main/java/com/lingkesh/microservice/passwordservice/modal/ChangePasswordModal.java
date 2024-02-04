package com.lingkesh.microservice.passwordservice.modal;

public class ChangePasswordModal {

    private long userId;
    private String username;
    private int oldPassword;
    private String newPassword;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(int oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
