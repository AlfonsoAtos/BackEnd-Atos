package com.atos.checkpoint.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.atos.checkpoint.entity.ShoppingCart;
import com.atos.checkpoint.mappers.ShoppingCartMapper;

@Component
public class ShoppingCartDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ShoppingCartMapper scm;

    public List<ShoppingCart> getAllCompletedCarts(int userID) {
        String sql = "select * from shoppingCart where cartStatus='Complete' and userID=:userID";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userID", userID);
        List<ShoppingCart> carts = jdbcTemplate.query(sql, paramMap, scm);
        if (carts.size() > 0) {
            return carts;
        } else {
            return null;
        }
    }

    public ShoppingCart getInSessionCart(int userID) {
        String sql = "select shoppingCartID, creationDate, cartStatus, userID from shoppingCart where cartStatus='Insession' and userID=:userID";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userID", userID);
        List<ShoppingCart> carts = jdbcTemplate.query(sql, paramMap, scm);
        ShoppingCart cart = carts.get(0);
        
        return cart;
    }

    public int createNewCart(int userID) {
        try {
            String sql = "insert into shoppingCart values ((select max(shoppingCartID)+1 from shoppingCart), (SELECT SYSDATE FROM DUAL), 'Insession', :userID)";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userID", userID);
            return jdbcTemplate.update(sql, paramMap);
        } catch (Exception e) {
            return 0;
        }
    }

    public int completeCart(int cartID){
     
            String sql = "update shoppingCart set cartStatus='Complete' where shoppingCartID=:cartID";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("cartID", cartID);
            return jdbcTemplate.update(sql, paramMap);
        
    }

}
