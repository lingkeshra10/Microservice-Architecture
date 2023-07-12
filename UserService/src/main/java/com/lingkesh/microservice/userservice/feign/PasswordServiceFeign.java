package com.lingkesh.microservice.userservice.feign;

import com.lingkesh.microservice.userservice.modal.RegisterPasswordModal;
import com.lingkesh.microservice.userservice.modal.ResponseModal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name ="password-service", url="localhost:8300")
public interface PasswordServiceFeign {

    @RequestMapping(value = "/password/registerUsrPwd", produces = "application/json", method = RequestMethod.PUT)
    ResponseEntity<ResponseModal> registerUserPassword(@RequestBody RegisterPasswordModal registerPasswordModal);

}
