package com.backend.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.entity.ShoppingProductDetails;
import com.backend.webproject.managers.CustomerSideManager;

@Controller
public class CustomerSideController {
	@Autowired
	CustomerSideManager customerSideManager;

	@RequestMapping("/")
	public String showHomePage(Model model) {
		customerSideManager.showHomePage(model);
		return "home";
	}

	@PostMapping("numproductsincart/{uID}")
	@ResponseBody
	public int getNumProductsInCartService(@PathVariable int uID, Model model) {
		return customerSideManager.getNumProductsInCartService(uID);
	}

	@PostMapping("productsincart/{uID}")
	@ResponseBody
	public List<ShoppingProductDetails> getProductsInCartService(@PathVariable int uID, Model model) {
		return customerSideManager.getProductsInCartService(uID);
	}

	@RequestMapping("search")
	public String searchProductsService(HttpServletRequest request, Model model) {
		customerSideManager.searchProductsService(request, model);
		return "products";
	}

	@PostMapping("addtocart/{pID}/{uID}")
	public String addToCartService(@PathVariable int pID, @PathVariable int uID) {
		return (customerSideManager.addToCartService(pID, uID) == 1) ? "home" : "";
	}
}
