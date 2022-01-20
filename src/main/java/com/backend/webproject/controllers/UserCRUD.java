package com.backend.webproject.controllers;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.database.UserDatabase;
import com.backend.models.AdminData;
import com.backend.models.UserData;

@RestController
@RequestMapping("/api/user")
public class UserCRUD {
	static UserDatabase db = new UserDatabase();
	
	@PostMapping("/signup")
	public UserData signupUser(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String name = req.getParameter("name");
		String number = req.getParameter("number");
		int id = db.getUserCount() + 1;
		
		if (db.registerUser(id, email, pass, name, number) == 1) {
			// Create shopping cart
			return new UserData(id, email, pass, name, number);
		}
		return null;
	}
	
	@PostMapping("/login")
	public UserData loginUser(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		UserData user = db.getUser(email);
		if (user != null && user.getPassword().equals(pass)) {
			return user;
		}
		return null;
	}
}
