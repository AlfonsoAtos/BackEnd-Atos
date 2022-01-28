package com.atos.checkpoint.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.atos.checkpoint.entity.ProductCategory;

@Component
public class ProductCategoryMapper implements RowMapper<ProductCategory> {
	@Override
	public ProductCategory mapRow(ResultSet result, int arg1) throws SQLException {
		ProductCategory obj = new ProductCategory();
		obj.setPcID(result.getInt(1));
		obj.setPcName(result.getString(2));
		obj.setPcDescription(result.getString(3));
		return obj;
	}
}