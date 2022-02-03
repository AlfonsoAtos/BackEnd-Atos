package com.backend.webproject.managers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.Model;

import com.backend.webproject.dao.ProductCategoryDAO;
import com.backend.webproject.dao.ProductDAO;
import com.backend.webproject.dao.ShoppingProductDetailsDAO;
import com.backend.webproject.entity.Product;
import com.backend.webproject.entity.ProductCategory;

@SpringBootTest
class CustomerSideManagerTests {
	@InjectMocks
	private CustomerSideManager customerSideManager;
	
	@Mock
	private ProductDAO productDAO;
	
	@Mock
	private ProductCategoryDAO productCategoryDAO;
	
	@Mock
	private ShoppingProductDetailsDAO shoppingProductDetailsDAO;
	
	@Mock
	private Model model;
	
	private ProductCategory createCategory() {
		return new ProductCategory(1, "Category", "Category description");
	}

	private Product createProduct() {
		return new Product(1, "Product Name Game", "Company", 100.0f, "Product Description", "image.png", 1);
	}
	
	@Test
	void showHomePageTest() {
		List<ProductCategory> productCategories = new ArrayList<>();
		productCategories.add(createCategory());
		List<Product> newProducts = new ArrayList<>();
		newProducts.add(createProduct());
		given(productCategoryDAO.getProductCategories()).willReturn(productCategories);
		given(productDAO.getNewProducts()).willReturn(newProducts);
		
		customerSideManager.showHomePage(model);
	}
	
	@Test
	void getNumProductsInCartServiceTest() {
		given(shoppingProductDetailsDAO.getNumProductsInCart(3)).willReturn(5);
		
		assertEquals(5, customerSideManager.getNumProductsInCartService(3));
	}

	@Test
	void searchProductsServiceTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		String pName = "Name";
		String pCategoryID = "2";
		
		List<ProductCategory> productCategories = new ArrayList<>();
		List<Product> searchResult = new ArrayList<>();
		given(productCategoryDAO.getProductCategories()).willReturn(productCategories);
		given(productDAO.searchProducts(pName, pCategoryID)).willReturn(searchResult);

		assertEquals("products", customerSideManager.searchProductsService(request, model));
	}
	
	@Test
	void addToCartServiceTest() {
		given(shoppingProductDetailsDAO.addToCart(3, 5)).willReturn(1);

		assertEquals(1, customerSideManager.addToCartService(3, 5));
	}
}
