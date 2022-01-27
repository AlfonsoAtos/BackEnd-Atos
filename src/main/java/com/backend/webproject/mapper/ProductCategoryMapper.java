package com.backend.webproject.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.backend.webproject.entity.ProductCategory;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper implements RowMapper<ProductCategory>
{
	@Override
	public ProductCategory mapRow(ResultSet result, int arg1) throws SQLException {
		ProductCategory obj = new ProductCategory();
		obj.setPcID(result.getInt(1));
		obj.setPcName(result.getString(2));
		obj.setPcDescription(result.getString(3));
		return obj;
	}
}