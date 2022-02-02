package com.atos.checkpoint.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.atos.checkpoint.entity.ShoppingCart;

@Component
public class ShoppingCartMapper implements RowMapper<ShoppingCart> {

    @Override
    public ShoppingCart mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        ShoppingCart sc = new ShoppingCart();
        sc.setShoppingCartID(rs.getInt(1));
        sc.setCreationDate(rs.getDate(2));
        sc.setCartStatus(rs.getString(3));
        sc.setUserID(rs.getInt(4));
        return sc;
    }
    
}
