package com.atos.checkpoint.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.atos.checkpoint.entity.Product;

@Component
public class ProductMapper implements RowMapper<Product>
{

	@Override
	public Product mapRow(ResultSet result, int arg1) throws SQLException {
		Product obj = new Product();
		obj.setPID(result.getInt(1));
		obj.setPName(result.getString(2));
		obj.setPCompany(result.getString(3));
		obj.setPPrice(result.getFloat(4));
		obj.setPDescription(result.getString(5));
		obj.setPImagePath(result.getString(6));
		obj.setPCategoryID(result.getInt(7));
		obj.setPFormattedPrice(obj.formatPrice(obj.getPPrice()));
		return obj;
	}

}

