package com.backend.webproject.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.backend.webproject.dao.ProductCategoryDAO;
import com.backend.webproject.dao.ProductDAO;
import com.backend.webproject.dao.ShoppingProductDetailsDAO;
import com.backend.webproject.entity.Product;
import com.backend.webproject.entity.ProductCategory;

@Component
public class CustomerSideManager {
    @Autowired
	ProductDAO productDAO;
	@Autowired
	ProductCategoryDAO productCategoryDAO;
	@Autowired
	ShoppingProductDetailsDAO shoppingProductDetailsDAO;

    public String showHomePage(Model model) {
        try {
            int numProductsInCart = shoppingProductDetailsDAO.getNumProductsInCart();
            model.addAttribute("numProductsInCart", numProductsInCart);
            List<ProductCategory> productCategories = productCategoryDAO.getProductCategories();
            model.addAttribute("productCategories", productCategories);
            List<Product> newProducts = productDAO.getNewProducts();
            model.addAttribute("newProducts", newProducts);
        } catch(Exception e) {
            System.out.println("Can not display homepage data, reason: '" + e + "'");
        }
        return "home";
    }

	public String searchProductsService(HttpServletRequest request, Model model) {
		try {
			int numProductsInCart = shoppingProductDetailsDAO.getNumProductsInCart();
			model.addAttribute("numProductsInCart", numProductsInCart);
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

	public String addToCartService(@PathVariable int pID) {
		String response = "";
		try {
			int productAdded = shoppingProductDetailsDAO.addToCart(pID);
			response = (productAdded == 1) ? "home" : "";
		} catch (Exception e) {
			System.out.println("Can not add to cart, reason: '" + e + "'");
		}
		return response;
	}
}