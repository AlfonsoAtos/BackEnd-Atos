package com.backend.database;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.backend.models.AdminData;
import com.backend.models.AdminMapper;

public class DatabaseConnection {
	static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");		
	static JdbcTemplate temp = (JdbcTemplate)context.getBean("jdbctemp");
	
	public List<AdminData> getAllEmployees() {
//		insertNewAdmin();
		List<AdminData> list = temp.query("select * from admin", new AdminMapper());
		System.out.println("Admin list");
		for(AdminData admin : list) {
			System.out.println("admin: " + admin.getName());
		}
		return list;
	}
	
	public AdminData getAdmin(String email) {
		AdminData admin = temp.queryForObject("select * from admin where email = ?", new Object[] {email}, new AdminMapper());
		return admin;
	}
	
	public void insertNewAdmin() {
//		temp.update("insert into admin values(3, 'Noelle', 'chio@chio.com', 'pass123')");
		temp.update("insert into admin values(4, 'Alejandra' , 'ale@ale.ale', 'pass123')");
	}
}
