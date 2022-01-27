package com.backend.webproject.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.backend.webproject.entity.UserEntity;

@Component
public class UserMapper implements RowMapper<UserEntity> {

	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserEntity obj = new UserEntity(
			rs.getInt(1), 
			rs.getString(2), 
			rs.getString(3), 
			rs.getString(4), 
			rs.getString(6), 
			rs.getInt(7));
		return obj;
	}

}
