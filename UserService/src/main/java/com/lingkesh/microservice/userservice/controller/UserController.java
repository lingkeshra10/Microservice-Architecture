package com.lingkesh.microservice.userservice.controller;

import com.lingkesh.microservice.userservice.entity.User;
import com.lingkesh.microservice.userservice.feign.PasswordServiceFeign;
import com.lingkesh.microservice.userservice.grpc.LogsServiceGrpc;
import com.lingkesh.microservice.userservice.modal.RegisterPasswordModal;
import com.lingkesh.microservice.userservice.modal.ResponseModal;
import com.lingkesh.microservice.userservice.modal.AddUserModal;
import com.lingkesh.microservice.userservice.modal.UpdateUserModal;
import com.lingkesh.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${grpc.server.hostname}")
    private String grpcServerHostname;

    @Value("${grpc.server.port}")
    private int grpcServerPort;

    @Autowired
    private PasswordServiceFeign passwdFeignService;

    @Autowired
    UserService userService;

    @GetMapping("/status/check")
    public String status() {
        return "Its working";
    }

    @RequestMapping(value = "/add", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> addUser(@RequestBody AddUserModal addUserModal){

        LogsServiceGrpc logsServiceGrpc = new LogsServiceGrpc();
        ResponseModal responseModal = new ResponseModal();

        //find the username exist or not
        boolean usernameResult = userService.findExistByUsername(addUserModal.getUsername());
        if(usernameResult){
            String remark = "Add User Failed. This username already exist: " + addUserModal.getUsername();
            logsServiceGrpc.addServiceLogs(1, ResponseModal.USERNAME_ALREADY_EXIST, remark, grpcServerHostname, grpcServerPort);

            responseModal.setCode(ResponseModal.USERNAME_ALREADY_EXIST);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.USERNAME_ALREADY_EXIST));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        //find the email exist or not
        boolean emailResult = userService.findExistByEmail(addUserModal.getEmail());
        if(emailResult){
            String remark = "Add User Failed. This email already exist: " + addUserModal.getEmail();
            logsServiceGrpc.addServiceLogs(1, ResponseModal.USERNAME_ALREADY_EXIST, remark, grpcServerHostname, grpcServerPort);

            responseModal.setCode(ResponseModal.EMAIL_ALREADY_EXIST);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.EMAIL_ALREADY_EXIST));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        User user = userService.saveUser(addUserModal);

        if(user != null){
            String remark = "Add User Successful. The user's username " + addUserModal.getUsername();
            logsServiceGrpc.addServiceLogs(1, ResponseModal.SUCCESS, remark, grpcServerHostname, grpcServerPort);

            //This place that need to send user password details to password table to make sure password records
            RegisterPasswordModal registerPasswordModal = new RegisterPasswordModal();
            registerPasswordModal.setUserId(user.getId());
            registerPasswordModal.setUsername(user.getUsername());
            registerPasswordModal.setNewPassword(user.getEncryptPassword());

            responseModal = passwdFeignService.registerUserPassword(registerPasswordModal).getBody();

            responseModal.setObject(user.toString());
            return ResponseEntity.status(HttpStatus.CREATED).body(responseModal);
        }else{
            String remark = "Add User Failed. The user's username " + addUserModal.getUsername();
            logsServiceGrpc.addServiceLogs(1, ResponseModal.ADD_USER_FAIL, remark, grpcServerHostname, grpcServerPort);

            responseModal.setCode(ResponseModal.ADD_USER_FAIL);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.ADD_USER_FAIL));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }
    }

    @RequestMapping(value = "/update", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> updateUser(@RequestBody UpdateUserModal updateUserModal){

        ResponseModal responseModal = new ResponseModal();
        boolean needToChangeEmail = false;
        boolean needToChangeName = false;

        //find the username exist or not
        boolean usernameResult = userService.findExistByUsername(updateUserModal.getUsername());

        if(!usernameResult){
            responseModal.setCode(ResponseModal.USER_NOT_EXIST);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.USER_NOT_EXIST));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        //Retrieve user details
        User user = userService.retrieveUserDetails(updateUserModal.getUsername());

        //Check the name got changes
        if(!user.getName().equals(updateUserModal.getName())){
            needToChangeName = true;
        }

        //Check the email got changes
        if(!user.getEmail().equals(updateUserModal.getEmail())){
            needToChangeEmail = true;

            //If email got changes check other using that email or not
            boolean emailResult = userService.findExistByEmail(updateUserModal.getEmail());
            if(emailResult){
                responseModal.setCode(ResponseModal.EMAIL_ALREADY_EXIST);
                responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.EMAIL_ALREADY_EXIST));
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
            }
        }

        user = userService.updateUser(user, updateUserModal.getName(), updateUserModal.getEmail(),
                needToChangeName, needToChangeEmail);

        //Return success message
        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));
        responseModal.setObject(user.toString());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseModal);
    }

    @RequestMapping(value = "/isUserExist/{username}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<ResponseModal> isUserExistByUsername(@PathVariable("username") String username){

        ResponseModal responseModal = new ResponseModal();

        //Find the username exist or not
        boolean usernameResult = userService.findExistByUsername(username);

        if(!usernameResult){
            responseModal.setCode(ResponseModal.USER_NOT_EXIST);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.USER_NOT_EXIST));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        //Extract the user details
        User user = userService.retrieveUserDetails(username);

        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));
        responseModal.setObject(user.toString());

        return ResponseEntity.status(HttpStatus.OK).body(responseModal);
    }

    @RequestMapping(value = "/listUser", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<ResponseModal> retrieveUserList(){

        ResponseModal responseModal = new ResponseModal();

        List<User> userList = userService.retrieveUserList();

        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));
        responseModal.setObject(userList.toString());

        return ResponseEntity.status(HttpStatus.OK).body(responseModal);
    }

    @RequestMapping(value = "/delete/{username}", produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseModal> deleteUser(@PathVariable("username") String username){

        ResponseModal responseModal = new ResponseModal();

        //Find the username exist or not
        boolean usernameResult = userService.findExistByUsername(username);

        if(!usernameResult){
            responseModal.setCode(ResponseModal.USER_NOT_EXIST);
            responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.USER_NOT_EXIST));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
        }

        //Proceed to delete the user
        userService.deleteUser(username);

        //Return the message
        responseModal.setCode(ResponseModal.SUCCESS);
        responseModal.setMessage(ResponseModal.getResponseMsg(ResponseModal.SUCCESS));

        return ResponseEntity.status(HttpStatus.OK).body(responseModal);
    }

}
