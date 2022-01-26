package com.backend.webproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.webproject.entity.UserEntity;
import com.backend.webproject.jtemp.UserDAO;

@RestController
@RequestMapping("/api/user")
public class UserAPI {
	@Autowired
	UserDAO db;
	
	@PostMapping("/signup")
	public UserEntity signupUser(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String name = req.getParameter("name");
		String number = req.getParameter("number");

		if (db.registerUser(email, pass, name, number) == 1) {
			// Create shopping cart
			return db.getUser(email);
		}
		return null;
	}

	@PostMapping("/login")
	public UserEntity loginUser(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		UserEntity user = db.getUser(email);
		if (user != null && user.getPassword().equals(pass)) {
			return user;
		}
		return null;
	}
}
