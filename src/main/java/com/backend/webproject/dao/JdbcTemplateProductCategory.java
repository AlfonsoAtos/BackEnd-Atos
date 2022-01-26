package com.backend.webproject.dao;

import java.util.List;

import com.backend.webproject.mappers.ProductCategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateProductCategory {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductCategoryMapper ProductCategoryMapper;

    public List<ProductCategory> getProductCategories() {
        List<ProductCategory> productCategories = jdbcTemplate.query("SELECT * FROM ProductCategory",
                ProductCategoryMapper);
        return productCategories;
    }
}
