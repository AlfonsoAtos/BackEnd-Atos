package com.backend.webproject.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import com.backend.webproject.entity.Coupons;
import com.backend.webproject.mappers.CouponsMapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class CouponsDAOTest {

    @InjectMocks
    CouponsDAO couponsDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private CouponsMapper couponsMapper;

    private Coupons createCoupon() {
        return new Coupons(1, "Winter", "1234567890", "Open", 40, 1, 1);
    }

    @Test
    public void couponsTestList() {
        List<Coupons> listCoupons = couponsDAO.getNewCoupons();
        assertTrue(listCoupons.isEmpty());
    }

    @Test
    public void couponsTestSearch() {
        Coupons coupon = createCoupon();
        List<Coupons> couponsList = new ArrayList<Coupons>();
        couponsList.add(coupon);
        given(jdbcTemplate.query(
                "SELECT * FROM coupon WHERE couponId = ?",
                new Object[] { coupon.getCouponId() },
                couponsMapper))
                        .willReturn(couponsList);

        Coupons result = couponsDAO.searchCouponByID(coupon.getCouponId());
        assertEquals(coupon, result);
    }

    @Test
    public void couponsTestInsert() {
        Coupons coupon = createCoupon();

        given(jdbcTemplate.update(
                "INSERT INTO coupon VALUES(?,?,?,?,?,?,?)",
                new Object[] {
                        coupon.getCouponId(),
                        coupon.getCouponName(),
                        coupon.getCouponCode(),
                        coupon.getCouponType(),
                        coupon.getCouponDiscount(),
                        coupon.getPromotionEventId(),
                        coupon.getProductCategoryId()
                }))
                        .willReturn(1);

        int result = couponsDAO.insertNewCoupon(
                coupon.getCouponId(),
                coupon.getCouponName(),
                coupon.getCouponCode(),
                coupon.getCouponType(),
                coupon.getCouponDiscount(),
                coupon.getPromotionEventId(),
                coupon.getProductCategoryId());
        assertEquals(1, result);
    }

    @Test
    public void couponsTestUpdate() {
        Coupons coupon = createCoupon();
        coupon.setCouponName("Coupon name");

        given(jdbcTemplate.update(
                "UPDATE coupon SET couponName = ?, couponCode = ?, couponType = ?, couponDiscount = ?, promotionEventId = ?, productCategoryId = ? where couponId=?",
                new Object[] {
                        coupon.getCouponName(),
                        coupon.getCouponCode(),
                        coupon.getCouponType(),
                        coupon.getCouponDiscount(),
                        coupon.getPromotionEventId(),
                        coupon.getProductCategoryId(),
                        coupon.getCouponId()
                }))
                        .willReturn(1);

        int result = couponsDAO.updateCoupon(
                coupon.getCouponId(),
                "Coupon name",
                coupon.getCouponCode(),
                coupon.getCouponType(),
                coupon.getCouponDiscount(),
                coupon.getPromotionEventId(),
                coupon.getProductCategoryId());
        assertEquals(1, result);
    }

    @Test
    public void couponsTestDelete() {
        given(jdbcTemplate.update(
                "DELETE FROM coupon WHERE couponId = ?",
                new Object[] { 2 }))
                        .willReturn(1);

        int result = couponsDAO.deleteCoupon(2);
        assertEquals(1, result);
    }

    @Test
    public void couponsTestAutoId() {
        given(jdbcTemplate.queryForObject(
                "SELECT MAX(couponId) + 1 FROM coupon",
                Integer.class))
                        .willReturn(3);

        int result = couponsDAO.getAutoCouponId();
        assertEquals(3, result);
    }

    @Test
    public void couponsTestValidate() {
        Coupons coupon = createCoupon();
        List<Coupons> couponsList = new ArrayList<Coupons>();
        couponsList.add(coupon);
        given(jdbcTemplate.query(
                "SELECT * FROM coupon WHERE couponCode = ?",
                new Object[] { coupon.getCouponCode() },
                couponsMapper))
                        .willReturn(couponsList);

        Coupons result = couponsDAO.validateCoupons(coupon.getCouponCode());
        assertEquals(coupon, result);
    }

}
