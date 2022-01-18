package com.backend.webproject.jtemp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateProducts {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ProductMapper ProductMapper;
    
    public List<Product> getNewProducts() {
        List<Product> newProducts = jdbcTemplate.query("SELECT * FROM (SELECT * FROM Product ORDER BY productID DESC) WHERE ROWNUM <= 5", ProductMapper);
        return newProducts;
	}

    public List<Product> searchProducts(String pName, String pCategoryID) {
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
        List<Product> searchResult = jdbcTemplate.query(sql, params, ProductMapper);

        return searchResult;
    }

}