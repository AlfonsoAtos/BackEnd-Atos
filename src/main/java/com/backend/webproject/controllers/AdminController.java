package com.backend.webproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/login")
	public String Login() {
		return "login_admin";
	}
}
