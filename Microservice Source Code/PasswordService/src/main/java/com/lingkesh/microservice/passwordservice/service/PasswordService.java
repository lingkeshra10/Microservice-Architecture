package com.lingkesh.microservice.passwordservice.service;

import com.lingkesh.microservice.passwordservice.entity.Password;

public interface PasswordService {

    boolean checkUserPassword(long userId, int userPassword);

    Password changePassword(long userId, int newPasswd);

}
