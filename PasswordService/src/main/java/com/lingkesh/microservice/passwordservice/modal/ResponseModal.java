package com.lingkesh.microservice.passwordservice.modal;

public class ResponseModal {

    int code;
    String message;
    String object;

    public final static int SUCCESS = 0;
    public final static int CHANGE_PASSWORD_FAIL = 20001;
    public final static int USER_NEW_PASSWORD_RECORD = 20002;
    public final static int USER_NEW_PASSWORD_CONDITIONS_NOT_MATCH = 20003;

    public static int EXCEPTION_ERROR = 500;

    public static String getResponseMsg(int code){
        switch (code) {
            case SUCCESS:
                return "Success";
            case CHANGE_PASSWORD_FAIL:
                return "User change password failed";
            case USER_NEW_PASSWORD_RECORD:
                return "User new password is under the password history record";
            case USER_NEW_PASSWORD_CONDITIONS_NOT_MATCH:
                return "User new password doesn't match the password conditions";

            case 500:
                return "Exception Error";
            default:
                return "";
        }
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
