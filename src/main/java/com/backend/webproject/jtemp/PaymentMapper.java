package com.backend.webproject.jtemp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PaymentMapper implements RowMapper<Payment>
{
	@Override
	public Payment mapRow(ResultSet result, int arg1) throws SQLException {

		Payment obj = new Payment();
        obj.setPaymentID(result.getInt(1));
		obj.setOpenCoupon(result.getInt(2));
		obj.setShoppingFinalAmount(result.getInt(3));
        obj.setPaymentStatus(result.getString(4));
        obj.setShoppingCartID(result.getInt(5));
		return obj;
	}

}