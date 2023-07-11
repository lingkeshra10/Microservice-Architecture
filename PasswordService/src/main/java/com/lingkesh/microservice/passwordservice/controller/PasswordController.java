package com.lingkesh.microservice.passwordservice.controller;

import com.lingkesh.microservice.passwordservice.entity.Password;
import com.lingkesh.microservice.passwordservice.grpc.LogsServiceGrpc;
import com.lingkesh.microservice.passwordservice.modal.ChangePasswordModal;
import com.lingkesh.microservice.passwordservice.modal.RegisterPasswordModal;
import com.lingkesh.microservice.passwordservice.modal.ResponseModal;
import com.lingkesh.microservice.passwordservice.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    PasswordService passwordService;

    @Value("${grpc.server.hostname}")
    private String grpcServerHostname;

    @Value("${grpc.server.port}")
    private int grpcServerPort;

    @RequestMapping(value = "/testingGRPC", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> test(){

        String remark;
        ResponseModal responseModal = new ResponseModal();
        LogsServiceGrpc logsServiceGrpc = new LogsServiceGrpc();
        long userId = 123123;
        logsServiceGrpc.addServiceLogs(userId, ResponseModal.SUCCESS, "", grpcServerHostname, grpcServerPort);

        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));
        responseModal.setObject("Its working");
        return ResponseEntity.status(HttpStatus.OK).body(responseModal);
    }

    @RequestMapping(value = "/registerUsrPwd", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> registerUserPassword(@RequestBody RegisterPasswordModal registerPasswordModal){

        String remark;
        ResponseModal responseModal = new ResponseModal();
        LogsServiceGrpc logsServiceGrpc = new LogsServiceGrpc();

        Password password = passwordService.changePassword(registerPasswordModal.getUserId(),
                registerPasswordModal.getNewPassword());

        if(password == null){
            remark = "User " + registerPasswordModal.getUsername() + " not able to register the password";
            logsServiceGrpc.addServiceLogs(registerPasswordModal.getUserId(), ResponseModal.CHANGE_PASSWORD_FAIL, remark, grpcServerHostname, grpcServerPort);

            responseModal.setCode(ResponseModal.CHANGE_PASSWORD_FAIL);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.CHANGE_PASSWORD_FAIL));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        remark = "User " + registerPasswordModal.getUsername() + " successfully register the password";
        logsServiceGrpc.addServiceLogs(registerPasswordModal.getUserId(), ResponseModal.SUCCESS, remark, grpcServerHostname, grpcServerPort);

        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));
        responseModal.setObject(password.toString());
        return ResponseEntity.status(HttpStatus.OK).body(responseModal);
    }

    //Need to revisit this API
    @RequestMapping(value = "/changeUsrPwd", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> addUser(@RequestBody ChangePasswordModal changePasswordModal){

        String remark;
        ResponseModal responseModal = new ResponseModal();
        LogsServiceGrpc logsServiceGrpc = new LogsServiceGrpc();

        //Make sure the new password have verified the first five user password
        boolean result = passwordService.checkUserPassword(changePasswordModal.getUserId(), changePasswordModal.getNewPassword().hashCode());

        if(!result){
            //Return response that user new password is among the first five old history password
            remark = "User" + changePasswordModal.getUsername() + " not able to register the password because its still under user old history password";
            logsServiceGrpc.addServiceLogs(changePasswordModal.getUserId(), ResponseModal.USER_NEW_PASSWORD_RECORD, remark, grpcServerHostname, grpcServerPort);

            responseModal.setCode(ResponseModal.USER_NEW_PASSWORD_RECORD);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.USER_NEW_PASSWORD_RECORD));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        //Change the user password
        Password password = passwordService.changePassword(changePasswordModal.getUserId(),
                changePasswordModal.getNewPassword().hashCode());

        if(password == null){
            remark = "User" + changePasswordModal.getUsername() + " not able to register the password";
            logsServiceGrpc.addServiceLogs(changePasswordModal.getUserId(), ResponseModal.CHANGE_PASSWORD_FAIL, remark, grpcServerHostname, grpcServerPort);

            responseModal.setCode(ResponseModal.CHANGE_PASSWORD_FAIL);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.CHANGE_PASSWORD_FAIL));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        //Return the result
        remark = "User " + changePasswordModal.getUsername() + " successfully register the password";
        logsServiceGrpc.addServiceLogs(changePasswordModal.getUserId(), ResponseModal.SUCCESS, remark, grpcServerHostname, grpcServerPort);

        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));
        responseModal.setObject(password.toString());
        return ResponseEntity.status(HttpStatus.OK).body(responseModal);
    }


}
