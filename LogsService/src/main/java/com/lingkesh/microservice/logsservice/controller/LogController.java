package com.lingkesh.microservice.logsservice.controller;

import com.lingkesh.microservice.logsservice.modal.AddLogModal;
import com.lingkesh.microservice.logsservice.modal.ResponseModal;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @RequestMapping(value = "/testLogs", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> testLogs(@RequestBody AddLogModal addLogModal){
        ResponseModal responseModal = new ResponseModal();
        responseModal.setCode(1001);
        responseModal.setMessage("GRPC is working");
        String object =  "Just testing";
        responseModal.setObject(object.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModal);
    }

    //add logs
    @RequestMapping(value = "/addUserLog", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<ResponseModal> addLogs(@RequestBody AddLogModal addLogModal){
        return null;
    }

    //list logs
    @RequestMapping(value = "/retrieveUserLog/{username}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<ResponseModal> retrieveLogs(@Param("username") String username){
        return null;
    }

}
