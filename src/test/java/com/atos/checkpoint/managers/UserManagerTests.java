package com.atos.checkpoint.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.atos.checkpoint.dao.UserDAO;
import com.atos.checkpoint.entity.User;
import com.atos.checkpoint.managers.UserManager;

import static org.mockito.BDDMockito.given;

@SpringBootTest
class UserManagerTests {
	@Autowired
	private UserManager userManager;

	@MockBean
	private UserDAO userDAO;

	@Test
	void loginUserTest() {
		User user = new User(1, "user@user.com", "pass123", "User", "8110", 1);

		given(userDAO.getUser("user@user.com")).willReturn(user);

		User userResult = userManager.loginUser("user@user.com", "pass123");
		assertEquals(user, userResult);
	}
	
	@Test
	void loginUserWrongInfoTest() {
		given(userDAO.getUser("user@user.com")).willReturn(null);

		User userResult = userManager.loginUser("user@user.com", "pass123");
		assertEquals(null, userResult);
		
		User user = new User(1, "user2@user.com", "pass", "User", "8110", 1);
		
		given(userDAO.getUser("user2@user.com")).willReturn(user);
		userResult = userManager.loginUser("user2@user.com", "pass123");
		assertEquals(null, userResult);
	}
	
	@Test
	void loginUserNullValuesTest() {
		assertEquals(null, userManager.loginUser("user@user.com", null));
		assertEquals(null, userManager.loginUser(null, "pass123"));
		assertEquals(null, userManager.loginUser(null, null));
	}
	
	
	@Test
	void signupUserTest() {
		User user = new User(1, "user@user.com", "pass123", "User", "8110", 1);

		given(userDAO.registerUser("user@user.com", "pass123", "User", "8110")).willReturn(1);
		given(userDAO.getUser("user@user.com")).willReturn(user);

		User userResult = userManager.signupUser("user@user.com", "pass123", "User", "8110");
		assertEquals(user, userResult);
	}
	
	@Test
	void signupUserErrorTest() {
		given(userDAO.registerUser("user@user.com", "pass123", "User", "8110")).willReturn(0);

		User userResult = userManager.signupUser("user@user.com", "pass123", "User", "8110");
		assertEquals(null, userResult);
	}

}
