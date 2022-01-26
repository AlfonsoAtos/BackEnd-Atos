package com.backend.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.jtemp.JdbcTemplateProducts;
import com.backend.webproject.jtemp.Product;

@Controller
public class CustomerSideController {
	@Autowired
	JdbcTemplateProducts jdbcTemplateProducts;

	@RequestMapping("/")
	public String showHomePage(Model model) {
		List<Product> newProducts = jdbcTemplateProducts.getNewProducts();
		model.addAttribute("newProducts", newProducts);
		return "home";
	}

    @RequestMapping("search")
	public String searchProductsService(HttpServletRequest request, Model model) {
		String pName = request.getParameter("pname");
		String pCategoryID = request.getParameter("pcatid");
		List<Product> searchResult = jdbcTemplateProducts.searchProducts(pName, pCategoryID);
		model.addAttribute("searchResult", searchResult);
		return "generalProducts";
	}

	@RequestMapping("shooter")
	public String searchShooter(HttpServletRequest request, Model model) {
		String pName = request.getParameter("pname");
		String pCategoryID = "1";
		List<Product> searchResult = jdbcTemplateProducts.searchProducts(pName, pCategoryID);
		model.addAttribute("searchResult", searchResult);
		return "shooter";
	}

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
		return jdbcTemplateProducts.searchProductByID(id);
	}
}
