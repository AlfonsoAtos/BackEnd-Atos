package com.backend.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AdminMapper implements RowMapper<AdminData> {

	@Override
	public AdminData mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminData obj = new AdminData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

		return obj;
	}

}
