package com.backend.webproject.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.backend.webproject.entity.UserData;

@Component
public class UserMapper implements RowMapper<UserData> {

	@Override
	public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserData obj = new UserData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		return obj;
	}

}
