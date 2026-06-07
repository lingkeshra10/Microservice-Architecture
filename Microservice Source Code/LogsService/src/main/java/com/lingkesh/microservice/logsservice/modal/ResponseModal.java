package com.lingkesh.microservice.logsservice.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModal {
    int code;
    String message;
    String object;

    public final static int SUCCESS = 0;
    public final static int ADD_LOG_FAIL = 20001;
    public final static int RETRIEVE_LOG_FAIL = 20002;

    public static int EXCEPTION_ERROR = 500;

    public static String getResponseMsg(int code){
        return switch (code) {
            case SUCCESS -> "Success";
            case ADD_LOG_FAIL -> "Add User Log failed";
            case RETRIEVE_LOG_FAIL -> "Retrieve User Log failed";
            case 500 -> "Exception Error";
            default -> "";
        };
    }
}
