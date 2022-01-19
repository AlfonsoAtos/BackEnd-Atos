package com.backend.webproject.jtemp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateProducts {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ProductMapper ProductMapper;

    public List<ProductsModel> getNewProducts() {
        List<ProductsModel> newProducts = jdbcTemplate.query(
                "SELECT * FROM (SELECT * FROM Product ORDER BY productID DESC) WHERE ROWNUM <= 5", ProductMapper);
        return newProducts;
    }

}
