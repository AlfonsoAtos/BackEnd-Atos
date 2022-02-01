package com.backend.webproject.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.backend.webproject.entity.User;
import com.backend.webproject.mappers.UserMapper;

@SpringBootTest
class UserDAOTest {
	
	@InjectMocks
	private UserDAO userDAO;

	@Mock
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Mock
	private UserMapper userMapper;

	@Test
	void getUserTest() {
		User user = new User(1, "user@user.com", "pass123", "User", "8110", 1);
		
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		given(jdbcTemplate.query(
				"select * from RegisteredUser where userEmail = :email",
				new HashMap<String, String>() {{
					put("email", user.getEmail());
				}},
				userMapper))
				.willReturn(userList);

		User userResult = userDAO.getUser("user@user.com");
		assertEquals(user, userResult);
	}
	
	@Test
	void userNotFoundTest() {

		List<User> userList = new ArrayList<User>();
		given(jdbcTemplate.query(
				"select * from RegisteredUser where userEmail = :email",
				new HashMap<String, String>() {{
					put("email", "user@user.com");
				}},
				userMapper))
				.willReturn(userList);

		User userResult = userDAO.getUser("user@user.com");
		assertEquals(null, userResult);
	}
	
	@Test
	void registerUserTest() {
		User user = new User(1, "user@user.com", "pass123", "User", "8110", 1);

		given(jdbcTemplate.update(
			"insert into RegisteredUser values((SELECT COALESCE(MAX(userID) + 1, 1) FROM RegisteredUser), :email, :pass, :name, :address, :number, 1)",
			new HashMap<String, String>() {{
				put("email", user.getEmail());
				put("pass", user.getPassword());
				put("name", user.getFullname());
				put("number", user.getNumber());
				put("address", "address");
			}}
		)).willReturn(1);

		int result = userDAO.registerUser("user@user.com", "pass123", "User", "8110");
		assertEquals(1, result);
	}
}
