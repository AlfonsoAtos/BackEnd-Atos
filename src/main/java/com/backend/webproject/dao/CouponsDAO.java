package com.backend.webproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend.webproject.entity.Coupons;
import com.backend.webproject.mappers.CouponsMapper;
import com.backend.webproject.mappers.CouponsMapperJoined;

//import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CouponsDAO {

    @Autowired
    JdbcTemplate temp;

    @Autowired
    private CouponsMapper couponsMapper;

    @Autowired
    private CouponsMapperJoined couponsMapperJoined;

    // Get the entire data from Coupon table
    public List<Coupons> getNewCoupons() {
        List<Coupons> newCoupons = temp.query(
                "SELECT * FROM Coupon ORDER BY couponId DESC", couponsMapper);
        return newCoupons;
    }

    public List<Coupons> getNewCouponsJoined() {
        List<Coupons> newCoupons = temp.query(
                "SELECT b.couponId, b.couponName, b.couponCode, b.couponType, b.couponDiscount, c.promotionEventName, a.categoryName FROM productcategory a, coupon b, promotionevent c WHERE a.productCategoryId = b.productCategoryId AND c.promotionEventId = b.promotionEventId ORDER BY couponId DESC",
                couponsMapperJoined);
        return newCoupons;
    }

    // Insert Query for Coupon table
    public int insertNewCoupon(int couponId, String couponName, String couponCode, String couponType,
            int couponDiscount, int promotionEventId, int productCategoryId) {
        return temp.update("INSERT INTO coupon VALUES(?,?,?,?,?,?,?)",
                new Object[] { couponId, couponName, couponCode,
                        couponType, couponDiscount, promotionEventId, productCategoryId });
    }

    public Coupons searchCouponByID(int couponId) {
        String sql = "SELECT * FROM coupon WHERE couponId = ?";
        Coupons couponsData = (Coupons) temp.query(sql, new Object[] { couponId }, couponsMapper).get(0);
        return couponsData;
    }

    // Edit Query for Coupon table
    public int updateCoupon(int couponId, String couponName, String couponCode, String couponType,
            int couponDiscount,
            int promotionEventId, int productCategoryId) {
        return temp.update(
                "UPDATE coupon SET couponName = ?, couponCode = ?, couponType = ?, couponDiscount = ?, promotionEventId = ?, productCategoryId = ? where couponId=?",
                new Object[] { couponName, couponCode, couponType, couponDiscount, promotionEventId,
                        productCategoryId,
                        couponId });
    }

    // Delete Query for Coupon table
    public int deleteCoupon(int couponId) {

        String sql = "DELETE FROM coupon WHERE couponId = ?";
        return temp.update(sql, couponId);
    }

    public int getAutoCouponId() {
        int newCouponId = temp.queryForObject("SELECT MAX(couponId) + 1 FROM coupon", Integer.class);
        return newCouponId;
    }

    public Coupons validateCoupons(String couponCode) {
        String sql = "SELECT * FROM coupon WHERE couponCode = ?";
        Coupons coupon = (Coupons) temp.query(sql, new Object[] { couponCode }, couponsMapper).get(0);
        return coupon;
    }

}
