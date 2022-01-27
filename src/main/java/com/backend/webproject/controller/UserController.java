package com.backend.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.webproject.dao.UserDAO;
import com.backend.webproject.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDAO db;
	
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
	
	@RequestMapping("/sign_up")
	public String SignUp() {
		return "sign_up";
	}
	
	@RequestMapping("/list")
	public String UsersList(Model model) {
//		List<UserModel> users = serviceUsers.list();
//		model.addAttribute("users", users);
		return "user_list";
	}

	@PostMapping("/api/signup")
	@ResponseBody
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

	@PostMapping("/api/login")
	@ResponseBody
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
