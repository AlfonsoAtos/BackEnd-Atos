package com.backend.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.webproject.entity.User;
import com.backend.webproject.dao.UserDAO;

@RestController
@RequestMapping("/api/user")
public class UserAPI {
	@Autowired
	UserDAO db;
	
	@PostMapping("/signup")
	public User signupUser(@RequestBody User user) {
		String email = user.getEmail();
		String pass = user.getPassword();
		String name = user.getFullname();
		String number = user.getNumber();
		
		if (db.registerUser(email, pass, name, number) == 1) {
			// Create shopping cart
			return db.getUser(email);
		}
		return null;
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) {
		String email = user.getEmail();
		String pass = user.getPassword();
		
		User userResult = db.getUser(email);
		if (userResult != null && userResult.getPassword() != null && userResult.getPassword().equals(pass)) {
			return userResult;
		}
		return null;
	}
}
