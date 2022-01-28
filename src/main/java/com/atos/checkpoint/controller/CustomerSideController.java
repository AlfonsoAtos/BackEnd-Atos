package com.atos.checkpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.atos.checkpoint.dao.ProductCategoryDAO;
import com.atos.checkpoint.dao.ProductDAO;
import com.atos.checkpoint.dao.ShoppingProductDetailsDAO;
import com.atos.checkpoint.entity.Product;
import com.atos.checkpoint.entity.ProductCategory;

@Controller
public class CustomerSideController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	ProductCategoryDAO productCategoryDAO;
	@Autowired
	ShoppingProductDetailsDAO shoppingProductDetailsDAO;

	@RequestMapping("/")
	public String showHomePage(Model model) {
		List<ProductCategory> productCategories = productCategoryDAO.getProductCategories();
		model.addAttribute("productCategories", productCategories);
		List<Product> newProducts = productDAO.getNewProducts();
		model.addAttribute("newProducts", newProducts);
		return "home";
	}

	@PostMapping("addtocart/{pID}")
	public String addToCartService(@PathVariable int pID){
		int productAdded = shoppingProductDetailsDAO.addToCart(pID);
		String response = (productAdded == 1) ? "home" : "";
		return response;
	}

    @RequestMapping("search")
	public String searchProductsService(HttpServletRequest request, Model model) {
		List<ProductCategory> productCategories = productCategoryDAO.getProductCategories();
		model.addAttribute("productCategories", productCategories);
		String pName = request.getParameter("pname");
		String pCategoryID = request.getParameter("pcatid");
		List<Product> searchResult = productDAO.searchProducts(pName, pCategoryID);
		model.addAttribute("searchResult", searchResult);
		return "products";
	}

	/* @RequestMapping("addtocart/{pID}")
	public String addToCartService(@PathVariable int pID) {
		int productAdded = shoppingProductDetailsDAO.addToCart(pID);
		return "redirect:/";
	} */

}
