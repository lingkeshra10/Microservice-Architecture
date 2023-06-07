package com.lingkesh.microservice.passwordservice.controller;

import com.lingkesh.microservice.passwordservice.entity.Password;
import com.lingkesh.microservice.passwordservice.grpc.LogsServiceGrpc;
import com.lingkesh.microservice.passwordservice.modal.ChangePasswordModal;
import com.lingkesh.microservice.passwordservice.modal.RegisterPasswordModal;
import com.lingkesh.microservice.passwordservice.modal.ResponseModal;
import com.lingkesh.microservice.passwordservice.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/registerUsrPwd", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> registerUserPassword(@RequestBody RegisterPasswordModal registerPasswordModal){

        String remark;
        ResponseModal responseModal = new ResponseModal();
        LogsServiceGrpc logsServiceGrpc = new LogsServiceGrpc();

        Password password = passwordService.changePassword(registerPasswordModal.getUserPasswordId(),
                registerPasswordModal.getNewPassword(), false);

        if(password == null){
            remark = "User " + registerPasswordModal.getUsername() + " not able to register the password";
            logsServiceGrpc.addLog(registerPasswordModal.getUserId(), ResponseModal.CHANGE_PASSWORD_FAIL, remark);

            responseModal.setCode(ResponseModal.CHANGE_PASSWORD_FAIL);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.CHANGE_PASSWORD_FAIL));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        remark = "User " + registerPasswordModal.getUsername() + " successfully register the password";
        logsServiceGrpc.addLog(registerPasswordModal.getUserId(), ResponseModal.SUCCESS, remark);

        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));
        responseModal.setObject(password.toString());
        return ResponseEntity.status(HttpStatus.OK).body(responseModal);
    }

    @RequestMapping(value = "/changeUsrPwd", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> addUser(@RequestBody ChangePasswordModal changePasswordModal){

        String remark;
        ResponseModal responseModal = new ResponseModal();
        LogsServiceGrpc logsServiceGrpc = new LogsServiceGrpc();

        //Make sure the new password have verified the first five user password
        boolean result = passwordService.checkUserPassword(changePasswordModal.getUserPasswordId(), changePasswordModal.getNewPassword());

        if(!result){
            //Return response that user new password is among the first five old history password
            remark = "User" + changePasswordModal.getUsername() + " not able to register the password because its still under user old history password";
            logsServiceGrpc.addLog(changePasswordModal.getUserId(), ResponseModal.USER_NEW_PASSWORD_RECORD, remark);

            responseModal.setCode(ResponseModal.USER_NEW_PASSWORD_RECORD);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.USER_NEW_PASSWORD_RECORD));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        //Change the user password
        Password password = passwordService.changePassword(changePasswordModal.getUserPasswordId(),
                changePasswordModal.getNewPassword(), true);

        if(password == null){
            remark = "User" + changePasswordModal.getUsername() + " not able to register the password";
            logsServiceGrpc.addLog(changePasswordModal.getUserId(), ResponseModal.CHANGE_PASSWORD_FAIL, remark);

            responseModal.setCode(ResponseModal.CHANGE_PASSWORD_FAIL);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.CHANGE_PASSWORD_FAIL));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        //Return the result
        remark = "User " + changePasswordModal.getUsername() + " successfully register the password";
        logsServiceGrpc.addLog(changePasswordModal.getUserId(), ResponseModal.SUCCESS, remark);

        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));
        responseModal.setObject(password.toString());
        return ResponseEntity.status(HttpStatus.OK).body(responseModal);
    }


}
