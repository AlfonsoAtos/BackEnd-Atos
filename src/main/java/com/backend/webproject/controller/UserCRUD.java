package com.backend.webproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.webproject.dao.JdbcTemplateRegisteredUsers;
import com.backend.webproject.entity.UserData;

@RestController
@RequestMapping("/api/user")
public class UserCRUD {
	@Autowired
	JdbcTemplateRegisteredUsers db;

	@PostMapping("/signup")
	public UserData signupUser(HttpServletRequest req, Model model) {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String name = req.getParameter("name");
		String number = req.getParameter("number");

		if (db.registerUser(email, pass, name, number) == 1) {
			// Create shopping cart
			return new UserData(-1, email, pass, name, number);
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
