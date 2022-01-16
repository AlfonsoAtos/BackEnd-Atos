package com.backend.webproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorld {

	@RequestMapping("/")
	public String Hello() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
}
