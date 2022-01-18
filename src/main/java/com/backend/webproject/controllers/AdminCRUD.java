package com.backend.webproject.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.database.AdminDatabase;
import com.backend.models.AdminData;

@RestController
@RequestMapping("/api/admin")
public class AdminCRUD {
	static AdminDatabase db = new AdminDatabase();
	
	@PostMapping("/login")
	public AdminData loginAdmin(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		AdminData admin = db.getAdmin(email);
		if (admin != null && admin.getPassword().equals(pass)) {
			admin.setPassword(null);
		}
		return admin;
	}
}
