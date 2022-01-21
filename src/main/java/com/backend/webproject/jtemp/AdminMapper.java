package com.backend.webproject.jtemp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.backend.webproject.entity.AdminData;

@Component
public class AdminMapper implements RowMapper<AdminData> {

	@Override
	public AdminData mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminData obj = new AdminData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

		return obj;
	}

}
