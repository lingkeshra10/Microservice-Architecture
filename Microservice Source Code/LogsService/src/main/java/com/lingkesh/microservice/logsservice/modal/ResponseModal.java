package com.lingkesh.microservice.logsservice.modal;

public class ResponseModal {

    int code;
    String message;
    String object;

    public final static int SUCCESS = 0;
    public final static int ADD_LOG_FAIL = 20001;
    public final static int RETRIEVE_LOG_FAIL = 20002;

    public static int EXCEPTION_ERROR = 500;

    public static String getResponseMsg(int code){
        switch (code) {
            case SUCCESS:
                return "Success";
            case ADD_LOG_FAIL:
                return "Add User Log failed";
            case RETRIEVE_LOG_FAIL:
                return "Retrieve User Log failed";

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
