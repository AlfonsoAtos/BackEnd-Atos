package com.backend.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.managers.CustomerSideManager;

@Controller
public class CustomerSideController {
	@Autowired
	CustomerSideManager customerSideManager;

	@RequestMapping("/")
	public String showHomePage(Model model) {
		return customerSideManager.showHomePage(model);
	}

	@RequestMapping("search")
	public String searchProductsService(HttpServletRequest request, Model model) {
		return customerSideManager.searchProductsService(request, model);
	}

	@PostMapping("addtocart/{pID}")
	public String addToCartService(@PathVariable int pID) {
		return customerSideManager.addToCartService(pID);
	}

}
