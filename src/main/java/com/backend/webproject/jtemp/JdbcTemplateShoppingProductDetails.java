package com.backend.webproject.jtemp;

import java.util.HashMap;
import java.util.Map;

import com.backend.webproject.entity.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateShoppingProductDetails {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ShoppingCartJDBC jdbcTemplateShoppingCart;
    @Autowired
    private JdbcTemplateProducts jdbcTemplateProducts;
    
    public int addToCart(int pID) {
        //Fixed value for testing
        int userID = 1;

        ShoppingCart inSessionCart = jdbcTemplateShoppingCart.getInSessionCart(userID);   
        if(inSessionCart == null) {
            jdbcTemplateShoppingCart.createNewCart(userID);
            inSessionCart = jdbcTemplateShoppingCart.getInSessionCart(userID);   
        }
        int inSessionCartId = inSessionCart.getShoppingCartID();

        Product product = jdbcTemplateProducts.getProductById(pID);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("quantity", 1);
        params.put("cost", product.pPrice);
        params.put("pID", product.pID);
        params.put("scID", inSessionCartId);
        int productExists = jdbcTemplate.queryForObject("SELECT COUNT(productID) FROM ShoppingProductDetails WHERE shoppingCartId = :scID AND productID = :pID", params, Integer.class);
        if(productExists == 1) {
            String sql = "UPDATE ShoppingProductDetails SET quantity = quantity + :quantity WHERE shoppingCartId = :scID AND productID = :pID";
            return jdbcTemplate.update(sql, params);
        } else {
            String sql = "INSERT INTO ShoppingProductDetails VALUES ((SELECT COALESCE(MAX(shoppingProductDetailsID) + 1, 1) FROM ShoppingProductDetails),:quantity,:cost,null,:pID,:scID)";
            return jdbcTemplate.update(sql, params);
        }
	}

}
