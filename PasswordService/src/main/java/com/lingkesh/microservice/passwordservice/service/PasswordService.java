package com.lingkesh.microservice.passwordservice.service;

import com.lingkesh.microservice.passwordservice.entity.Password;

public interface PasswordService {

    boolean checkUserPassword(String userId, String userPassword);

    Password changePassword(String userId, String newPasswd, boolean flagToEncrypt);

}
