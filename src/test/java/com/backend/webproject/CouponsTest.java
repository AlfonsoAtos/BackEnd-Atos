package com.backend.webproject;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import com.backend.webproject.dao.CouponsDAO;
import com.backend.webproject.entity.Coupons;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class CouponsTest {

    @MockBean
    CouponsDAO couponsDAO = mock(CouponsDAO.class);

    @Test
    public void testList() {
        List<Coupons> listCoupon = couponsDAO.getNewCoupons();
        assertTrue(listCoupon.isEmpty());
    }

    @Test
    void testInsert() {
        couponsDAO.insertNewCoupon(1, "Thanks Giving", "XYZ12345AB", "Open", 40, 1, 1);
    }

    @Test
    void testUpdateCoupon() {
        couponsDAO.updateCoupon(1, "Summer", "XYZ12345AB", "Nopen", 40, 1, 1);
    }

    @Test
    void testDeleteCoupon() {
        couponsDAO.deleteCoupon(1);
    }

    @Test
    void testGetAutoCouponId() {
        couponsDAO.getAutoCouponId();
    }

    @Test
    void testSearchCoupon() {
        couponsDAO.searchCouponByID(1);
    }
}
