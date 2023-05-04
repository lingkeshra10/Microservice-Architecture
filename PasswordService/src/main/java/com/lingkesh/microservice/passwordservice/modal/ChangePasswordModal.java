package com.lingkesh.microservice.passwordservice.modal;

public class ChangePasswordModal {

    private String userPasswordId;
    private String oldPassword;
    private String newPassword;

    public String getUserPasswordId() {
        return userPasswordId;
    }

    public void setUserPasswordId(String userPasswordId) {
        this.userPasswordId = userPasswordId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
