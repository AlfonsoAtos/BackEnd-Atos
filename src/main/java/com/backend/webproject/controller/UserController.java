package com.backend.webproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {	
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
}
