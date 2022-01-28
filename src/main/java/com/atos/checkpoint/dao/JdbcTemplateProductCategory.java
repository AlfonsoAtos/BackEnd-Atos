package com.atos.checkpoint.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.atos.checkpoint.entity.ProductCategory;
import com.atos.checkpoint.mappers.ProductCategoryMapper;

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
