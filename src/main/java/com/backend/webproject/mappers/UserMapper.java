package com.backend.webproject.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.backend.webproject.entity.User;

@Component
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User obj = new User(
			rs.getInt(1), 
			rs.getString(2), 
			rs.getString(3), 
			rs.getString(4), 
			rs.getString(6), 
			rs.getInt(7));
		return obj;
	}

}
