package com.backend.webproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.dao.ProductCategoryDAO;
import com.backend.webproject.dao.ProductDAO;
import com.backend.webproject.dao.ShoppingProductDetailsDAO;
import com.backend.webproject.entity.Product;
import com.backend.webproject.entity.ProductCategory;

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

	@PostMapping("addtocart/{pID}/{uID}")
	public String addToCartService(@PathVariable int pID, @PathVariable int uID){
		int productAdded = shoppingProductDetailsDAO.addToCart(pID, uID);
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
