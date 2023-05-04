package com.lingkesh.microservice.userservice.modal;

public class ResponseModal {

    int code;
    String message;
    String object;

    public static int SUCCESS = 0;
    public static int ADD_USER_FAIL = 10001;
    public static int UPDATE_USER_FAIL = 10002;
    public static int RETRIEVE_USER_FAIL = 10003;
    public static int RETRIEVE_USER_LIST_FAIL = 10004;
    public static int USER_NOT_EXIST = 10005;
    public static int USERNAME_ALREADY_EXIST = 10006;
    public static  int EMAIL_ALREADY_EXIST = 10007;

    public static int EXCEPTION_ERROR = 500;

    public static String getResponseMsg(int code){
        switch (code) {
            case 0:
                return "Success";
            case 10001:
                return "Add User Failed";
            case 10002:
                return "Update User Failed";
            case 10003:
                return "Retrieve User Details failed";
            case 10004:
                return "Retrieve list of user failed";
            case 10005:
                return "User is not exist";
            case 10006:
                return "Failed the username is already exist";
            case 10007:
                return "Failed the email is already exist";

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
