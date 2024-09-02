package com.lingkesh.microservice.userservice.service;

import com.lingkesh.microservice.userservice.entity.User;
import com.lingkesh.microservice.userservice.modal.AddUserModal;

import java.util.List;

public interface UserService {

    User saveUser(AddUserModal addUserModal);

    User updateUser(User user, String name, String email, boolean needToChangeName, boolean needToChangeEmail);

    User retrieveUserDetails(String username);

    List<User> retrieveUserList();

    List<User> searchListOfUser(String username, String email, int status, String uniqueId, String applicationId,
                                String phoneNumber, String startDate, String endDate, String start, String limit);

    boolean findExistByUsername(String username);

    boolean findExistByEmail(String email);

    void deleteUser(String username);

}
