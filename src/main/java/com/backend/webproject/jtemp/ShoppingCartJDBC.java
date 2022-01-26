package com.backend.webproject.jtemp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.webproject.entity.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartJDBC {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private ShoppingCartMapper scm;

    public List<ShoppingCart> getAllCompletedCarts(int userID) {
        String sql = "select * from shoppingCart where cartStatus='Complete' userID=:userID";
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
        String sql = "select * from shoppingCart where cartStatus='Insession' and userID=:userID";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userID", userID);
        List<ShoppingCart> carts = jdbcTemplate.query(sql, paramMap, scm);
        return carts.get(0);
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

    public int completeCart(int cartID, int userID){
     
            String sql = "update shoppingCart set cartStatus='Complete' where shoppingCartID=:cartID";
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("cartID", cartID);
            //this.createNewCart(userID);
            return jdbcTemplate.update(sql, paramMap);
        
    }

}
