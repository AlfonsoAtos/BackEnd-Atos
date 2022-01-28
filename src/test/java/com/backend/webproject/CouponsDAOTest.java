package com.backend.webproject;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import com.backend.webproject.dao.CouponsDAO;
import com.backend.webproject.entity.Coupons;
import com.backend.webproject.mappers.CouponsMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import static org.mockito.Mockito.when;

@SpringBootTest
class CouponsTest {

    // @MockBean
    // CouponsDAO couponsDAO = mock(CouponsDAO.class);

    @Autowired
    private CouponsDAO couponsDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Mock
    private CouponsMapper couponsMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        couponsDAO = new CouponsDAO(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Test
    public void testList() {
        Coupons coupon1 = new Coupons();
        coupon1.setCouponId(1);
        List<Coupons> expectedCouponsList = new ArrayList<Coupons>();
        expectedCouponsList.add(coupon1);

        when(jdbcTemplate.query(
                "SELECT * FROM (SELECT * FROM Coupon ORDER BY couponId DESC) WHERE ROWNUM <= 5",
                couponsMapper)).thenReturn(expectedCouponsList);

        List<Coupons> actualListCoupon = couponsDAO.getNewCoupons();
        assertEquals(expectedCouponsList.size(), actualListCoupon.size());
        assertEquals(expectedCouponsList.get(0).getCouponId(), actualListCoupon.get(0).getCouponId());
    }

    @Test
    void testInsert() {
        couponsDAO.insertNewCoupon(1, "Thanks Giving", "XYZ12345AB", "Open", 40, 1, 1);
    }

    // @Test
    // void testUpdateCoupon() {
    // couponsDAO.updateCoupon(1, "Summer", "XYZ12345AB", "Nopen", 40, 1, 1);
    // }

    // @Test
    // void testDeleteCoupon() {
    // couponsDAO.deleteCoupon(1);
    // }

    // @Test
    // void testGetAutoCouponId() {
    // couponsDAO.getAutoCouponId();
    // }

    // @Test
    // void testSearchCoupon() {
    // couponsDAO.searchCouponByID(1);
    // }
}
