package com.lingkesh.microservice.EmailService.modal;

public class ResponseModal {

    int code;
    String message;
    String object;

    public static int EMAIL_SEND_SUCCESS = 0;
    public static int EMAIL_SEND_FAIL = 30001;
    public static int EMAIL_ADD_QUEUE_SUCCESSFULLY = 30002;
    public static int EMAIL_ADD_QUEUE_FAILED = 30003;
    public static int EXCEPTION_ERROR = 500;

    public static String getResponseMsg(int code){
        return switch (code) {
            case 30001 -> "Email Send SuccessFully";
            case 30002 -> "Send Email Failed";
            case 30003 -> "Email successfully added in the queue";
            case 30004 -> "Email failed added in the queue";
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
