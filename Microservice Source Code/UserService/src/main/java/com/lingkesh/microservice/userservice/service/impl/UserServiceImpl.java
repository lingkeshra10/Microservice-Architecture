package com.lingkesh.microservice.userservice.service.impl;

import com.lingkesh.microservice.userservice.entity.User;
import com.lingkesh.microservice.userservice.modal.AddUserModal;
import com.lingkesh.microservice.userservice.repository.UserListSpecification;
import com.lingkesh.microservice.userservice.repository.UserRepo;
import com.lingkesh.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
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
    public List<User> searchListOfUser(String username, String email, int status, String uniqueId, String applicationId,
                                       String phoneNumber, String startDate, String endDate,
                                       String start, String limit) {
        int startIndex = Integer.parseInt(start);
        int pageSize = Integer.parseInt(limit);
        Pageable pageable = PageRequest.of(startIndex, pageSize);

        // Define the date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

        // Parse startDate and endDate strings to LocalDateTime
        LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

        // In case startDate and endDate are the same, adjust endDateTime to the end of the minute
        if (startDateTime.isEqual(endDateTime)) {
            endDateTime = endDateTime.plusMinutes(1).minusSeconds(1);
        }

        Specification<User> spec = Specification.where(UserListSpecification.hasUsername(username))
                .and(UserListSpecification.createdDateBetween(startDateTime, endDateTime))
                .and(UserListSpecification.hasUniqueId(uniqueId))
                .and(UserListSpecification.hasApplicationId(applicationId))
                .and(UserListSpecification.hasStatus(status))
                .and(UserListSpecification.hasUserPhoneNumber(phoneNumber))
                .and(UserListSpecification.hasUserEmail(email));

        return userRepo.findAll(spec, pageable).getContent();
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
