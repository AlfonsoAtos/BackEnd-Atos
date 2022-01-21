package com.backend.webproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.webproject.entity.AdminData;
import com.backend.webproject.jtemp.JdbcTemplateAdmins;

@RestController
@RequestMapping("/api/admin")
public class AdminCRUD {
	@Autowired
	JdbcTemplateAdmins db;
	
	@PostMapping("/login")
	public AdminData loginAdmin(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		AdminData admin = db.getAdmin(email);
		if (admin != null && admin.getPassword().equals(pass)) {
			return admin;
		}
		return null;
	}
}
