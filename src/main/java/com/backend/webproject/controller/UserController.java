package com.backend.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.webproject.dao.UserDAO;
import com.backend.webproject.entity.User;
import com.backend.webproject.managers.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserManager userManager;
	
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

		return userManager.signupUser(email, pass, name, number);
	}

	@PostMapping("/api/login")
	@ResponseBody
	public User loginUser(@RequestBody User user) {
		String email = user.getEmail();
		String pass = user.getPassword();
		return userManager.loginUser(email, pass);
	}

	@RequestMapping("/check/{cid}")
	public String userCart(@PathVariable int cid) {
		return "checkout";
	}
}
