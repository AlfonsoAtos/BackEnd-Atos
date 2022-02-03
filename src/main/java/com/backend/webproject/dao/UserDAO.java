package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.backend.webproject.entity.User;
import com.backend.webproject.mappers.UserMapper;

@Component
public class UserDAO {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private UserMapper userMapper;

	public User getUser(String email) {
		List<User> user = jdbcTemplate.query(
				"select * from RegisteredUser where userEmail = :email",
				new HashMap<String, String>() {{
					put("email", email);
				}}, 
				userMapper);
		if (user.size() > 0) {			
			return user.get(0);
		}
		return null;
	}

	public int registerUser(String email, String pass, String name, String number) {
		try {
			return jdbcTemplate.update(
				"insert into RegisteredUser values((SELECT COALESCE(MAX(userID) + 1, 1) FROM RegisteredUser), :email, :pass, :name, :address, :number, 1)",
				new HashMap<String, String>() {{
					put("email", email);
					put("pass", pass);
					put("name", name);
					put("number", number);
					put("address", "address");
				}}
			);
		} catch (DataAccessException err) {
			err.printStackTrace();
		}
		return 0;
	}
}
