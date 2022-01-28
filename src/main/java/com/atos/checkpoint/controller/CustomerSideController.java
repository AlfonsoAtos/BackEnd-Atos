package com.atos.checkpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atos.checkpoint.dao.JdbcTemplateProductCategory;
import com.atos.checkpoint.dao.JdbcTemplateProducts;
import com.atos.checkpoint.dao.JdbcTemplateShoppingProductDetails;
import com.atos.checkpoint.entity.Product;
import com.atos.checkpoint.entity.ProductCategory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public void addToCartService(@PathVariable int pID) {
		int productAdded = jdbcTemplateShoppingProductDetails.addToCart(pID);
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

	/*
	 * @RequestMapping("addtocart/{pID}")
	 * public String addToCartService(@PathVariable int pID) {
	 * int productAdded = jdbcTemplateShoppingProductDetails.addToCart(pID);
	 * return "redirect:/";
	 * }
	 */

	@RequestMapping("rpg")
	public String searchRpg(HttpServletRequest request, Model model) {
		String pName = request.getParameter("pname");
		String pCategoryID = "2";
		List<Product> searchResult = jdbcTemplateProducts.searchProducts(pName, pCategoryID);
		model.addAttribute("searchResult", searchResult);
		return "rpg";
	}

	@RequestMapping("simulation")
	public String searchSimulation(HttpServletRequest request, Model model) {
		String pName = request.getParameter("pname");
		String pCategoryID = "3";
		List<Product> searchResult = jdbcTemplateProducts.searchProducts(pName, pCategoryID);
		model.addAttribute("searchResult", searchResult);
		return "simulation";
	}

	public Product getProductByID(int id){
		return jdbcTemplateProducts.getProductById(id);
	}
}
