package com.backend.webproject.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.backend.webproject.entity.ShoppingProductDetails;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

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