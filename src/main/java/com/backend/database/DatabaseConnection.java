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
}
