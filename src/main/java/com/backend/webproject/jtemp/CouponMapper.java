package com.backend.webproject.jtemp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CouponMapper implements RowMapper<CouponModel> {

    @Override
    public CouponModel mapRow(ResultSet result, int arg1) throws SQLException {
        CouponModel obj = new CouponModel();
        obj.setcID(result.getInt(1));
        obj.setcName(result.getString(2));
        obj.setcCode(result.getString(3));
        obj.setcType(result.getString(4));
        obj.setcDiscount(result.getInt(5));
        obj.setpEventID(result.getInt(6));
        obj.setpCategoryID(result.getInt(7));
        return obj;
    }

}
