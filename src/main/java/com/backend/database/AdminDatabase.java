package com.backend.database;

import com.backend.models.AdminData;
import com.backend.models.AdminMapper;

public class AdminDatabase extends DatabaseConnection {
	public AdminData getAdmin(String email) {
		AdminData admin = temp.queryForObject("select * from admin where email = ?", new Object[] {email}, new AdminMapper());
		return admin;
	}
	
	public void insertNewAdmin() {
		temp.update("insert into admin values(4, 'Alejandra' , 'ale@ale.ale', 'pass123')");
	}
}
