package com.backend.webproject.jtemp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.backend.webproject.entity.UserEntity;
import com.backend.webproject.mapper.UserMapper;

@Component
public class UserDAO {
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private UserMapper userMapper;
	
	public UserEntity getUser(String email) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		List<UserEntity> user = jdbcTemplate.query("select * from RegisteredUser where userEmail = :email", params, userMapper);
		return user.get(0);
	}
	
	public int registerUser(String email, String pass, String name, String number) {
		try {
			String id = "(SELECT COALESCE(MAX(RegisteredUser) + 1, 1) FROM RegisteredUser)";
			String insert = "insert into RegisteredUser values(";
			String values = ", :email, :pass, :name, :address, :number, 1)";
	        String sql = insert + id + values;
	        Map<String, Object> params = new HashMap<>();
	        params.put("email", email);
	        params.put("pass", pass);
	        params.put("name", name);
	        params.put("number", number);
	        params.put("address", "address");
			return jdbcTemplate.update(sql, params);
		} catch(DataAccessException err) {
			err.printStackTrace();
		}
		return 0;
	}
}
