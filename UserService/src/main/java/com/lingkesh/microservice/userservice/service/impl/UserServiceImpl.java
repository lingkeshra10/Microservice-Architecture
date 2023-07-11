package com.lingkesh.microservice.userservice.service.impl;

import com.lingkesh.microservice.userservice.entity.User;
import com.lingkesh.microservice.userservice.kafka.modal.EmailModal;
import com.lingkesh.microservice.userservice.kafka.producer.EmailServiceProducer;
import com.lingkesh.microservice.userservice.modal.AddUserModal;
import com.lingkesh.microservice.userservice.repository.UserRepo;
import com.lingkesh.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;
    EmailServiceProducer producer;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder, EmailServiceProducer producer) {
        this.userRepo = userRepo;
        this.producer = producer;
    }

    @Override
    public User saveUser(AddUserModal addUserModal) {
        try {
            User user = new User();
            user.setName(addUserModal.getName());
            user.setEmail(addUserModal.getEmail());
            user.setUsername(addUserModal.getUsername());
            user.setEncryptPassword(addUserModal.getPassword().hashCode());

            userRepo.save(user);

            //Send Email to the User
            EmailModal emailModal = new EmailModal();
            emailModal.setEmail(addUserModal.getEmail());
            emailModal.setUsername(addUserModal.getUsername());
            emailModal.setEmailNotificationType("1");

            producer.sendMessage(emailModal);

            return user;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public User updateUser(User user, String name, String email, boolean needToChangeName, boolean needToChangeEmail) {
        if(needToChangeName || needToChangeEmail){
            //If all good proceed to change and if not don't proceed to change
            if(needToChangeName){
                user.setName(name);;
            }

            if(needToChangeEmail){
                user.setEmail(email);
            }
            userRepo.save(user);
        }

        return user;
    }

    @Override
    public User retrieveUserDetails(String username) {
        return userRepo.retrieveByUsername(username);
    }

    @Override
    public List<User> retrieveUserList() {
        return userRepo.findAll();
    }

    @Override
    public boolean findExistByUsername(String username) {
        return userRepo.findExistByUsername(username);
    }

    @Override
    public boolean findExistByEmail(String email) {
        return userRepo.findExistByEmail(email);
    }

    @Override
    public void deleteUser(String username) {

        User user = userRepo.retrieveByUsername(username);

        userRepo.delete(user);
    }


}
