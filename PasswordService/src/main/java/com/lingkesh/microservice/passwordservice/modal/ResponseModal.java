package com.lingkesh.microservice.passwordservice.modal;

public class ResponseModal {

    int code;
    String message;
    String object;

    public final static int USER_REGISTER_PASSWORD_SUCCESS = 20001;
    public final static int USER_REGISTER_PASSWORD_FAILED = 20002;
    public final static int USER_CHANGE_PASSWORD_SUCCESS = 20003;
    public final static int USER_CHANGE_PASSWORD_FAILED = 20004;
    public final static int USER_NEW_PASSWORD_RECORD = 20005;
    public final static int USER_NEW_PASSWORD_CONDITIONS_NOT_MATCH = 20006;

    public static int EXCEPTION_ERROR = 500;

    public static String getResponseMsg(int code){
        return switch (code) {
            case USER_REGISTER_PASSWORD_SUCCESS -> "User register password successfully";
            case USER_REGISTER_PASSWORD_FAILED -> "User register password failed";
            case USER_CHANGE_PASSWORD_SUCCESS -> "User change password successfully";
            case USER_CHANGE_PASSWORD_FAILED -> "User change password failed";
            case USER_NEW_PASSWORD_RECORD -> "User new password is under the password history record";
            case USER_NEW_PASSWORD_CONDITIONS_NOT_MATCH -> "User new password doesn't match the password conditions";
            case 500 -> "Exception Error";
            default -> "";
        };
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
