package com.lingkesh.microservice.passwordservice.service.impl;

import com.lingkesh.microservice.passwordservice.entity.Password;
import com.lingkesh.microservice.passwordservice.repository.PasswordRepo;
import com.lingkesh.microservice.passwordservice.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.regex.Pattern.matches;

@Service
public class PasswordServiceImpl implements PasswordService {

    PasswordRepo passwordRepo;

    @Autowired
    public PasswordServiceImpl(PasswordRepo passwordRepo) {
        this.passwordRepo = passwordRepo;
    }

    @Override
    public boolean checkUserPassword(long userId, int userPassword) {

        //Pageable firstPageWithFiveElements = PageRequest.of(0, 5, Sort.by("created_date").ascending());
        //Retrieve first 5 userPassword in the List
        List<Password> passwordList =  passwordRepo.retrieveUserPassword(userId).subList(0, 5);

        for (Password password : passwordList) {
            boolean result = matches(String.valueOf(userPassword), String.valueOf(password.getUser_password()));
            if (result) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Password changePassword(long userId, int newPasswd) {
        try {
            //Add the user password in the password table as record
            Password password = new Password();
            password.setUser_password(newPasswd);
            password.setPassword_user_id(userId);
            password.setCreated_date(System.currentTimeMillis());

            passwordRepo.save(password);

            return password;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
