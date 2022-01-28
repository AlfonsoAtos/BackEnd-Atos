package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.webproject.entity.Product;
import com.backend.webproject.entity.ShoppingCart;
import com.backend.webproject.entity.ShoppingProductDetails;
import com.backend.webproject.mappers.ShoppingProductDetailsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShoppingProductDetailsDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    @Autowired
    private ShoppingProductDetailsMapper spdm;
    
    @Autowired
    private ProductDAO productDAO;
    
    public int addToCart(int pID) {
        //Fixed value for testing
        int userID = 1;

        ShoppingCart inSessionCart = shoppingCartDAO.getInSessionCart(userID);   
        if(inSessionCart == null) {
            shoppingCartDAO.createNewCart(userID);
            inSessionCart = shoppingCartDAO.getInSessionCart(userID);   
        }
        int inSessionCartId = inSessionCart.getShoppingCartID();

        Product product = productDAO.getProductById(pID);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("quantity", 1);
        params.put("cost", product.getPPrice());
        params.put("pID", product.getPID());
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

    public List<ShoppingProductDetails> getAllDetailsFromCart(int cartID) {
        String sql = "select * from shoppingproductdetails where shoppingCartID=:cartID";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("cartID", cartID);
        List<ShoppingProductDetails> list = jdbcTemplate.query(sql, paramMap, spdm);
        return list;
    }

}
