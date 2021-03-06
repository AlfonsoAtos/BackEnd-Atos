package com.backend.webproject.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;
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

	public void showHomePage(Model model) {
		try {
			List<ProductCategory> productCategories = productCategoryDAO.getProductCategories();
			model.addAttribute("productCategories", productCategories);
			List<Product> newProducts = productDAO.getNewProducts();
			model.addAttribute("newProducts", newProducts);
		} catch(Exception e) {
			System.out.println("Can not display homepage data, reason: '" + e + "'");
		}
	}

	public int getNumProductsInCartService(int uID) {
		return shoppingProductDetailsDAO.getNumProductsInCart(uID);
	}

	public List<ShoppingProductDetails> getProductsInCartService(int userID) {
		try {
			ShoppingCart inSessionCart = shoppingCartDAO.getInSessionCart(userID);
			int inSessionCartID = inSessionCart.getShoppingCartID();
			List<ShoppingProductDetails> productsInCart = shoppingProductDetailsDAO.getAllDetailsFromCart(inSessionCartID);
			return productsInCart;
		} catch(Exception e) {
			return new ArrayList<ShoppingProductDetails>();
		}
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

	public int addToCartService(int pID, int uID) {
		try {
			return shoppingProductDetailsDAO.addToCart(pID, uID);
		} catch (Exception e) {
			System.out.println("Can not add to cart, reason: '" + e + "'");
		}
		return 0;
	}
}
