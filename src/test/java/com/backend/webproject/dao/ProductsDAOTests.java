package com.backend.webproject.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.backend.webproject.entity.Product;
import com.backend.webproject.mappers.ProductMapper;

@SpringBootTest
class ProductsDAOTests {

	@InjectMocks
	private ProductDAO productDAO;

	@Mock
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Mock
	private ProductMapper productMapper;

	private Product createProduct() {
		return new Product(1, "Product Name Game", "Company", 100.0f, "Product Description", "image.png", 1);
	}

	@Test
	void getNewProductsTest() {
		Product product = createProduct();

		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		given(jdbcTemplate.query(
			"SELECT * FROM (SELECT * FROM Product ORDER BY productID DESC) WHERE ROWNUM <= 8",
			productMapper))
			.willReturn(productList);

		assertEquals(productList, productDAO.getNewProducts());
	}
	
	@Test
	void searchProductsTest() {
		Product product = createProduct();
		String pName = "game";
		String pCategoryID = "1";
		
		StringJoiner where = new StringJoiner(" AND ", " WHERE ", "").setEmptyValue("");
        if (pName != null && !pName.trim().isEmpty()) {
            where.add("regexp_like(productName, :pName, 'i')");
        }
        if (pCategoryID != null && !pCategoryID.trim().isEmpty()) {
            where.add("productCategoryID = :pCategoryID");
        }
        String sql = "SELECT * FROM Product" + where + " ORDER BY productName";
        Map<String, Object> params = new HashMap<>();
        params.put("pName", pName);
        params.put("pCategoryID", pCategoryID);
        
        List<Product> productList = new ArrayList<Product>();
		productList.add(product);

		given(jdbcTemplate.query(sql, params, productMapper)).willReturn(productList);

		assertEquals(productList, productDAO.searchProducts(pName, pCategoryID));
	}

	@Test
	void getProductByIdTest() {
		Product product = createProduct();

		given(jdbcTemplate.queryForObject(
			"SELECT * FROM Product WHERE productID = :pID",
			new HashMap<String, Object>() {{put("pID", 1);}},
			productMapper))
			.willReturn(product);

		assertEquals(product, productDAO.getProductById(1));
	}


}
