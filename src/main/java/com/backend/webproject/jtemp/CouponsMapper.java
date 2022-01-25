package com.backend.webproject.jtemp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.backend.webproject.entity.Coupons;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CouponsMapper implements RowMapper<Coupons> {

    @Override
    public Coupons mapRow(ResultSet result, int arg1) throws SQLException {
        Coupons obj = new Coupons();
        obj.setCouponId(result.getInt(1));
        obj.setCouponName(result.getString(2));
        obj.setCouponCode(result.getString(3));
        obj.setCouponType(result.getString(4));
        obj.setCouponDiscount(result.getInt(5));
        obj.setPromotionEventId(result.getInt(6));
        obj.setProductCategoryId(result.getInt(7));
        return obj;
    }

}
