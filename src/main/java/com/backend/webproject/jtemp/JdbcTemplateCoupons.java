package com.backend.webproject.jtemp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateCoupons {

    JdbcTemplate temp;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private CouponsMapper couponsMapper;

    // Get the entire data from Coupon table
    public List<Coupons> getNewCoupons() {
        List<Coupons> newCoupons = jdbcTemplate.query(
                "SELECT * FROM (SELECT * FROM Coupon ORDER BY couponId DESC) WHERE ROWNUM <= 5", couponsMapper);
        return newCoupons;
    }

    // Insert Query for Coupon table
    public void insertNewCoupon(int couponId, String couponName, String couponCode, String couponType,
            int couponDiscount, int promotionEventId, int productCategoryId) {
        temp.update("insert into coupon values(?,?,?,?,?,?,?)", new Object[] { couponId, couponName, couponCode,
                couponType, couponDiscount, promotionEventId, productCategoryId });
    }

    // Edit Query for Coupon table
    public void updateCoupon(int couponId, String couponName, String couponCode, String couponType, int couponDiscount,
            int promotionEventId, int productCategoryId) {
        temp.update(
                "update coupon set couponName = ?, couponCode = ?, couponType = ?, couponDiscount = ?, promotionEventId = ?, productCategoryId = ? where couponId=?",
                new Object[] { couponName, couponCode, couponType, couponDiscount, promotionEventId, productCategoryId,
                        couponId });
    }

    // Delete Query for Coupon table
    public void deleteCoupon(int couponId) {
        temp.update("delete from coupon where couponId = ?", new Object[] { couponId });
    }

}
