package com.lingkesh.microservice.userservice;

import com.lingkesh.microservice.userservice.controller.UserController;
import com.lingkesh.microservice.userservice.entity.User;
import com.lingkesh.microservice.userservice.feign.PasswordServiceFeign;
import com.lingkesh.microservice.userservice.grpc.LogsServiceGrpc;
import com.lingkesh.microservice.userservice.kafka.producer.EmailServiceProducer;
import com.lingkesh.microservice.userservice.modal.AddUserModal;
import com.lingkesh.microservice.userservice.modal.RegisterPasswordModal;
import com.lingkesh.microservice.userservice.modal.ResponseModal;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceApplicationTests {

	private MockMvc mockMvc;
	@InjectMocks
	private UserController userController;

	@Mock
	private UserService userService;
	@MockBean
	private EmailServiceProducer producer;
	@MockBean
	private LogsServiceGrpc logsServiceGrpc;
	@MockBean
	private PasswordServiceFeign passwdFeignService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

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

}
