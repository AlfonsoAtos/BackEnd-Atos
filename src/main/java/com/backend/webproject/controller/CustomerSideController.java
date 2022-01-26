package com.backend.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.jtemp.JdbcTemplateProductCategory;
import com.backend.webproject.jtemp.JdbcTemplateProducts;
import com.backend.webproject.jtemp.JdbcTemplateShoppingProductDetails;
import com.backend.webproject.jtemp.Product;
import com.backend.webproject.jtemp.ProductCategory;

@Controller
public class CustomerSideController {
	@Autowired
	JdbcTemplateProducts jdbcTemplateProducts;
	@Autowired
	JdbcTemplateProductCategory jdbcTemplateProductCategory;
	@Autowired
	JdbcTemplateShoppingProductDetails jdbcTemplateShoppingProductDetails;

	@RequestMapping("/")
	public String showHomePage(Model model) {
		List<ProductCategory> productCategories = jdbcTemplateProductCategory.getProductCategories();
		model.addAttribute("productCategories", productCategories);
		List<Product> newProducts = jdbcTemplateProducts.getNewProducts();
		model.addAttribute("newProducts", newProducts);
		return "home";
	}

	@PostMapping("addtocart/{pID}")
	public String addToCartService(@PathVariable int pID){
		int productAdded = jdbcTemplateShoppingProductDetails.addToCart(pID);
		String response = (productAdded == 1) ? "home" : "";
		return response;
	}

    @RequestMapping("search")
	public String searchProductsService(HttpServletRequest request, Model model) {
		List<ProductCategory> productCategories = jdbcTemplateProductCategory.getProductCategories();
		model.addAttribute("productCategories", productCategories);
		String pName = request.getParameter("pname");
		String pCategoryID = request.getParameter("pcatid");
		List<Product> searchResult = jdbcTemplateProducts.searchProducts(pName, pCategoryID);
		model.addAttribute("searchResult", searchResult);
		return "products";
	}

	/* @RequestMapping("addtocart/{pID}")
	public String addToCartService(@PathVariable int pID) {
		int productAdded = jdbcTemplateShoppingProductDetails.addToCart(pID);
		return "redirect:/";
	} */

}
