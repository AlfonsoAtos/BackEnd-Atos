package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.webproject.entity.Coupons;
import com.backend.webproject.mappers.CouponsMapper;

//import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CouponsDAO {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CouponsDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Autowired
    private CouponsMapper couponsMapper;

    // Get the entire data from Coupon table
    public List<Coupons> getNewCoupons() {
        List<Coupons> newCoupons = jdbcTemplate.query(
                "SELECT * FROM (SELECT * FROM Coupon ORDER BY couponId DESC) WHERE ROWNUM <= 5", couponsMapper);
        return newCoupons;
    }

    // Insert Query for Coupon table
    public int insertNewCoupon(int couponId, String couponName, String couponCode, String couponType,
            int couponDiscount, int promotionEventId, int productCategoryId) {
        return jdbcTemplate.update("INSERT INTO coupon VALUES(?,?,?,?,?,?,?)",
                new Object[] { couponId, couponName, couponCode,
                        couponType, couponDiscount, promotionEventId, productCategoryId });
    }

    public Coupons searchCouponByID(int couponId) {
        String sql = "SELECT * FROM coupon WHERE couponId = ?";
        Coupons coupons = (Coupons) jdbcTemplate.query(sql, new Object[] { couponId }, couponsMapper).get(0);
        return coupons;
    }

    // Edit Query for Coupon table
    public int updateCoupon(int couponId, String couponName, String couponCode, String couponType, int couponDiscount,
            int promotionEventId, int productCategoryId) {
        return jdbcTemplate.update(
                "UPDATE coupon SET couponName = ?, couponCode = ?, couponType = ?, couponDiscount = ?, promotionEventId = ?, productCategoryId = ? where couponId=?",
                new Object[] { couponName, couponCode, couponType, couponDiscount, promotionEventId, productCategoryId,
                        couponId });
    }

    // Delete Query for Coupon table
    public int deleteCoupon(int couponId) {

        String sql = "DELETE FROM coupon WHERE couponId = ?";
        return jdbcTemplate.update(sql, couponId);
    }

    public int getAutoCouponId() {
        int newCouponId = jdbcTemplate.queryForObject("SELECT MAX(couponId) + 1 FROM coupon", Integer.class);
        return newCouponId;
    }

    public Coupons validateCoupons(String couponCode) {
        String sql = "SELECT * FROM coupon WHERE couponCode = :couponCode";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("couponCode", couponCode);
        Coupons coupon = namedParameterJdbcTemplate.query(sql, paramMap, couponsMapper).get(0);
        return coupon;
    }

}
