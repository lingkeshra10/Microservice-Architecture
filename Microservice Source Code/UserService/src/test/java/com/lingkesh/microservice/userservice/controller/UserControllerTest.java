package com.lingkesh.microservice.userservice.controller;

import com.lingkesh.microservice.userservice.entity.User;
import com.lingkesh.microservice.userservice.feign.PasswordServiceFeign;
import com.lingkesh.microservice.userservice.grpc.LogsServiceGrpc;
import com.lingkesh.microservice.userservice.kafka.producer.EmailServiceProducer;
import com.lingkesh.microservice.userservice.modal.AddUserModal;
import com.lingkesh.microservice.userservice.modal.RegisterPasswordModal;
import com.lingkesh.microservice.userservice.modal.ResponseModal;
import com.lingkesh.microservice.userservice.modal.UpdateUserModal;
import com.lingkesh.microservice.userservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTest {
    // @MockMvc simulate HTTP requests in Spring MVC tests without starting a full web server.
    // However, in this test, it's declared but not used directly.
    // It's common in integration tests where you want to perform full end-to-end tests on controllers.
    private MockMvc mockMvc;

    // @Mock is used to create mock instances of the UserService class.
    // Mocks allow you to simulate the behavior of complex, real objects and control their interactions during testing.
    @Mock
    private UserService userService;

    // @MockBean creates mock instances of Spring beans
    // (EmailServiceProducer, LogsServiceGrpc, and PasswordServiceFeign),
    // ensuring that the real beans are not loaded in the test context.
    @MockBean
    private EmailServiceProducer producer;
    @MockBean
    private LogsServiceGrpc logsServiceGrpc;
    @MockBean
    private PasswordServiceFeign passwdFeignService;

    // @InjectMocks annotation is used to inject the mock dependencies
    // (those annotated with @Mock or @MockBean) into the UserController.
    // This allows the test to interact with the UserController with all its dependencies mocked.
    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        //Initializes the mocks and injects them into the UserController before each test runs.
        MockitoAnnotations.initMocks(this);
    }

    //This method tests the behavior of the addUser endpoint in the UserController when trying to add a user with an existing username.
    @Test
    public void testAddUser_WhenUsernameExists_ShouldReturnBadRequest() {
        AddUserModal addUserModal = new AddUserModal();
        addUserModal.setUsername("existingUser");
        addUserModal.setEmail("existing@example.com");

        when(userService.findExistByUsername(addUserModal.getUsername())).thenReturn(true);

        ResponseEntity<ResponseModal> response = userController.addUser(addUserModal);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseModal.USERNAME_ALREADY_EXIST, response.getBody().getCode());
    }

    @Test
    public void testAddUser_WhenEmailExists_ShouldReturnBadRequest() {
        AddUserModal addUserModal = new AddUserModal();
        addUserModal.setUsername("newUser");
        addUserModal.setEmail("existing@example.com");

        when(userService.findExistByUsername(addUserModal.getUsername())).thenReturn(false);
        when(userService.findExistByEmail(addUserModal.getEmail())).thenReturn(true);

        ResponseEntity<ResponseModal> response = userController.addUser(addUserModal);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseModal.EMAIL_ALREADY_EXIST, response.getBody().getCode());
    }

    @Test
    public void testAddUser_WhenUserIsCreated_ShouldReturnCreated() {
        AddUserModal addUserModal = new AddUserModal();
        addUserModal.setUsername("newUser");
        addUserModal.setEmail("new@example.com");

        when(userService.findExistByUsername(addUserModal.getUsername())).thenReturn(false);
        when(userService.findExistByEmail(addUserModal.getEmail())).thenReturn(false);

        User user = new User();
        user.setId(1L);
        user.setUsername(addUserModal.getUsername());
        user.setEmail(addUserModal.getEmail());

        when(userService.saveUser(any(AddUserModal.class))).thenReturn(user);

        // Mock the PasswordServiceFeign behavior
        ResponseModal responseModal = new ResponseModal();
        responseModal.setCode(ResponseModal.ADD_USER_SUCCESS);
        responseModal.setObject(String.valueOf(user));

        ResponseEntity<ResponseModal> mockResponse = ResponseEntity.ok(responseModal);
        when(passwdFeignService.registerUserPassword(any(RegisterPasswordModal.class))).thenReturn(mockResponse);

        ResponseEntity<ResponseModal> response = userController.addUser(addUserModal);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ResponseModal.ADD_USER_SUCCESS, response.getBody().getCode());
        assertNotNull(response.getBody().getObject());
    }

    @Test
    public void testUpdateUser_WhenUsernameNotExists_ShouldReturnBadRequest() {
        UpdateUserModal updateUserModal = new UpdateUserModal();
        updateUserModal.setUsername("notExistingUser");
        updateUserModal.setEmail("existing@example.com");

        // Mock the behavior of userService to return false when checking for the existence of the username
        when(userService.findExistByUsername(updateUserModal.getUsername())).thenReturn(false);

        ResponseEntity<ResponseModal> response = userController.updateUser(updateUserModal);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseModal.USER_NOT_EXIST, response.getBody().getCode());
    }

    @Test
    public void testUpdateUser_WhenEmailExists_ShouldReturnBadRequest() {
        String name = "blackRock";
        String username = "existingUser";
        String userEmail =  "Existing1@example.com";
        String userEmail2 = "existing2@example.com";

        UpdateUserModal updateUserModal = new UpdateUserModal();
        updateUserModal.setName(name);
        updateUserModal.setUsername(username);
        updateUserModal.setEmail(userEmail);

        User user = new User();
        user.setId(1L);
        user.setName(name);
        user.setUsername(username);
        user.setEmail(userEmail2);

        // Mock the behavior of userService to return true when checking for the existence of the username
        when(userService.findExistByUsername(updateUserModal.getUsername())).thenReturn(true);

        when(userService.retrieveUserDetails(updateUserModal.getUsername())).thenReturn(user);

        when(userService.findExistByEmail(updateUserModal.getEmail())).thenReturn(true);

        ResponseEntity<ResponseModal> response = userController.updateUser(updateUserModal);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseModal.EMAIL_ALREADY_EXIST, response.getBody().getCode());
    }

    @Test
    public void testUpdateUser_ShouldReturnAccepted() {
        boolean needToChangeName = true;
        boolean needToChangeEmail = true;

        String name = "blackRock";
        String username = "existingUser";
        String userEmail = "Existing1@example.com";

        String updatedName = "blackRock2";
        String updatedUserEmail = "existing2@example.com";

        UpdateUserModal updateUserModal = new UpdateUserModal();
        updateUserModal.setName(updatedName);
        updateUserModal.setUsername(username);
        updateUserModal.setEmail(updatedUserEmail);

        User user = new User();
        user.setId(1L);
        user.setName(name);
        user.setUsername(username);
        user.setEmail(userEmail);

        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setName(updatedName);
        updatedUser.setUsername(username);
        updatedUser.setEmail(updatedUserEmail);

        // Mock the behavior of userService
        when(userService.findExistByUsername(updateUserModal.getUsername())).thenReturn(true);
        when(userService.retrieveUserDetails(updateUserModal.getUsername())).thenReturn(user);
        when(userService.findExistByEmail(updateUserModal.getEmail())).thenReturn(false);
        when(userService.updateUser(user, updatedName, updatedUserEmail, needToChangeName, needToChangeEmail)).thenReturn(updatedUser);

        // Optionally, log what the mock returns to ensure it's correct
        User returnedUser = userService.updateUser(user, updatedName, updatedUserEmail, needToChangeName, needToChangeEmail);
        System.out.println("Mocked updatedUser: " + returnedUser);

        ResponseEntity<ResponseModal> response = userController.updateUser(updateUserModal);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(ResponseModal.UPDATE_USER_SUCCESS, response.getBody().getCode());
        assertNotNull(response.getBody().getObject());
    }


    @Test
    public void testIsUserExists_ShouldReturnBadRequest() {
        String username = "notExistingUser";

        // Mock the behavior of userService to return false when checking for the existence of the username
        when(userService.findExistByUsername(username)).thenReturn(false);

        ResponseEntity<ResponseModal> response = userController.isUserExistByUsername(username);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseModal.USER_NOT_EXIST, response.getBody().getCode());
    }

    @Test
    public void testIsUserExists_ShouldReturnOk() {
        String username = "existingUser";
        String email = "existing@example.com";

        User user = new User();
        user.setId(1L);
        user.setUsername(username);
        user.setEmail(email);

        // Mock the behavior of userService to return true when checking for the existence of the username
        when(userService.findExistByUsername(username)).thenReturn(true);

        when(userService.retrieveUserDetails(username)).thenReturn(user);

        ResponseEntity<ResponseModal> response = userController.isUserExistByUsername(username);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseModal.USER_EXIST, response.getBody().getCode());
    }

    @Test
    public void testDeleteUser_WhenUsernameNotExists_ShouldReturnBadRequest() {
        String username = "notExistingUser";

        // Mock the behavior of userService to return false when checking for the existence of the username
        when(userService.findExistByUsername(username)).thenReturn(false);

        // Call the deleteUser method
        ResponseEntity<ResponseModal> response = userController.deleteUser(username);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseModal.USER_NOT_EXIST, response.getBody().getCode());
    }

    @Test
    public void testDeleteUser_ShouldReturnOk() {
        String username = "notExistingUser";

        // Mock the behavior of userService to return true when checking for the existence of the username
        when(userService.findExistByUsername(username)).thenReturn(true);

        // Mock the deletion process (you can also verify if deleteUser was called)
        doNothing().when(userService).deleteUser(username);

        // Call the deleteUser method
        ResponseEntity<ResponseModal> response = userController.deleteUser(username);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseModal.DELETE_USER_SUCCESS, response.getBody().getCode());
    }

}