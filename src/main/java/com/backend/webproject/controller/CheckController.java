package com.backend.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend.webproject.jtemp.JdbcTemplateProducts;

@Controller
public class CheckController {
	@Autowired
	JdbcTemplateProducts jdbcTemplateProducts;

	@RequestMapping("/checkout/test")
	public String checktest(Model model) {
		return "checkout";
	}
}
