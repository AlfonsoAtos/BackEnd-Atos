package com.backend.webproject.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.backend.webproject.entity.ProductCategory;
import com.backend.webproject.mappers.ProductCategoryMapper;

@SpringBootTest
class ProductCategoryDAOTests {

	@InjectMocks
	private ProductCategoryDAO categoryDAO;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private ProductCategoryMapper categoryMapper;

	@Test
	void productCategoryDAOTests() {
		ProductCategory category = new ProductCategory();
		category.setPcID(1);
		category.setPcName("Category");
		category.setPcDescription("Category Description");
		
		List<ProductCategory> categoryList = new ArrayList<ProductCategory>();
		categoryList.add(category);
		given(jdbcTemplate.query(
			"SELECT * FROM ProductCategory",
			categoryMapper))
			.willReturn(categoryList);

		List<ProductCategory> result = categoryDAO.getProductCategories();
		assertEquals(categoryList, result);
		assertEquals(categoryList.size(), result.size());
		assertEquals(categoryList.get(0), result.get(0));
	}

}
