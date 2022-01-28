package com.atos.checkpoint.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.atos.checkpoint.entity.ShoppingProductDetails;

@Component
public class ShoppingProductDetailsMapper implements RowMapper<ShoppingProductDetails> {
	@Override
	public ShoppingProductDetails mapRow(ResultSet rs, int arg1) throws SQLException {
        ShoppingProductDetails obj = new ShoppingProductDetails();
        obj.setShoppingProductDetailsID(rs.getInt(1));
        obj.setQuantity(rs.getInt(2));
        obj.setShoppingCost(rs.getInt(3));
        obj.setCostAfterApplyingCoupon(rs.getInt(4));
        obj.setProductID(rs.getInt(5));
        obj.setShoppingCartID(rs.getInt(6));
		return obj;
	}

}