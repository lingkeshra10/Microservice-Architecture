package com.lingkesh.microservice.passwordservice.modal;

public class RegisterPasswordModal {

    private String userPasswordId;
    private String newPassword;

    public String getUserPasswordId() {
        return userPasswordId;
    }

    public void setUserPasswordId(String userPasswordId) {
        this.userPasswordId = userPasswordId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
