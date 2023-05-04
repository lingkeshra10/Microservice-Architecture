package com.lingkesh.microservice.passwordservice.service.impl;

import com.lingkesh.microservice.passwordservice.entity.Password;
import com.lingkesh.microservice.passwordservice.repository.PasswordRepo;
import com.lingkesh.microservice.passwordservice.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordServiceImpl implements PasswordService {

    PasswordRepo passwordRepo;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PasswordServiceImpl(PasswordRepo passwordRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passwordRepo = passwordRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean checkUserPassword(String userId, String userPassword) {

        //Pageable firstPageWithFiveElements = PageRequest.of(0, 5, Sort.by("created_date").ascending());
        System.out.println("The userId: " + userId);
        System.out.println("The userPassword: " + userPassword);

        //Retrieve first 5 userPassword in the List
        List<Password> passwordList =  passwordRepo.retrieveUserPassword(userId).subList(0, 5);

        System.out.println("The password list size: " + passwordList.size());

        for (Password password : passwordList) {
            boolean result = bCryptPasswordEncoder.matches(userPassword, password.getUser_password());
            System.out.println("The result: " + result);
            if (result) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Password changePassword(String userId, String newPasswd, boolean flagToEncrypt) {
        try {
            //Add the user password in the password table as record
            Password password = new Password();
            if (flagToEncrypt) {
                password.setUser_password(bCryptPasswordEncoder.encode(newPasswd));
            } else {
                password.setUser_password(newPasswd);
            }
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
