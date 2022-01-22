package com.backend.webproject.jtemp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.backend.webproject.entity.AdminData;

@Component
public class JdbcTemplateAdmins {
	@Autowired
    public NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
    private AdminMapper adminMapper;
	
	public AdminData getAdmin(String email) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		List<AdminData> admin = jdbcTemplate.query("select * from admin where email = :email", params, adminMapper);
		return admin.get(0);
	}
}
