package com.backend.webproject.jtemp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateCoupons {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private CouponMapper CouponMapper;

    public List<CouponModel> getNewCoupons() {
        List<CouponModel> newCoupons = jdbcTemplate.query(
                "SELECT * FROM (SELECT * FROM coupon ORDER BY couponID DESC) WHERE ROWNUM <= 5", CouponMapper);
        return newCoupons;
    }

}
