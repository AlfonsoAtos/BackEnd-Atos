package com.backend.webproject.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.dao.ProductCategoryDAO;
import com.backend.webproject.dao.ProductDAO;
import com.backend.webproject.dao.ShoppingCartDAO;
import com.backend.webproject.dao.ShoppingProductDetailsDAO;
import com.backend.webproject.entity.Product;
import com.backend.webproject.entity.ProductCategory;
import com.backend.webproject.entity.ShoppingCart;
import com.backend.webproject.entity.ShoppingProductDetails;

@Component
public class CustomerSideManager {
	@Autowired
	ProductDAO productDAO;

	@Autowired
	ProductCategoryDAO productCategoryDAO;

	@Autowired
	ShoppingProductDetailsDAO shoppingProductDetailsDAO;

	@Autowired
	ShoppingCartDAO shoppingCartDAO;

	public String showHomePage(Model model) {
		try {
			List<ProductCategory> productCategories = productCategoryDAO.getProductCategories();
			model.addAttribute("productCategories", productCategories);
			List<Product> newProducts = productDAO.getNewProducts();
			model.addAttribute("newProducts", newProducts);
		} catch(Exception e) {
			System.out.println("Can not display homepage data, reason: '" + e + "'");
		}
		return "home";
	}

	public int getNumProductsInCartService(@PathVariable int uID, Model model) {
		int numProductsInCart = shoppingProductDetailsDAO.getNumProductsInCart(uID);
		return numProductsInCart;
	}

	public List<ShoppingProductDetails> getProductsInCartService(int userID) {
		List<ShoppingProductDetails> productsInCart;
		ShoppingCart inSessionCart = shoppingCartDAO.getInSessionCart(userID);
		int inSessionCartID = inSessionCart.getShoppingCartID();
		productsInCart = shoppingProductDetailsDAO.getAllDetailsFromCart(inSessionCartID);
		return productsInCart;
	}

	public String searchProductsService(HttpServletRequest request, Model model) {
		try {
			List<ProductCategory> productCategories = productCategoryDAO.getProductCategories();
			model.addAttribute("productCategories", productCategories);
			String pName = request.getParameter("pname");
			String pCategoryID = request.getParameter("pcatid");
			List<Product> searchResult = productDAO.searchProducts(pName, pCategoryID);
			model.addAttribute("searchResult", searchResult);
		} catch (Exception e) {
			System.out.println("Can not search products, reason: '" + e + "'");
		}
		return "products";
	}

	public String addToCartService(int pID, int uID) {
		String response = "";
		try {
			int productAdded = shoppingProductDetailsDAO.addToCart(pID, uID);
			response = (productAdded == 1) ? "home" : "";
		} catch (Exception e) {
			System.out.println("Can not add to cart, reason: '" + e + "'");
		}
		return response;
	}
}