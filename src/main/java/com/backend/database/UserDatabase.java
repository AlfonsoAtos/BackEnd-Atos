package com.backend.database;

import com.backend.models.UserMapper;

import org.springframework.dao.DataAccessException;

import com.backend.models.UserData;

public class UserDatabase extends DatabaseConnection {
	public UserData getUser(String username) {
		UserData user = temp.queryForObject("select * from RegisteredUser where userLoginID = ?", new Object[] {username}, new UserMapper());
		user.setPassword(null);
		return user;
	}
	
	public int registerUser(String email, String pass, String name, String number) {
		try {
			return temp.update("insert into RegisteredUser values(?, ?, ?, ?, '', ?", new Object[] {1, email, pass, name, number});
		} catch(DataAccessException err) {
			err.printStackTrace();
		}
		return 0;
	}
}
