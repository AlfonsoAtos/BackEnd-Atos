package com.backend.webproject;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import com.backend.webproject.dao.CouponsDAO;
import com.backend.webproject.entity.Coupons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class CouponsTest {

    @MockBean
    CouponsDAO couponsDAO = mock(CouponsDAO.class);;

    // @BeforeEach
    // void setUp() throws Exception {
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
    // dataSource.setUsername("system");
    // dataSource.setPassword("edu511");
    // dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");

    // couponsDAO = new couponsDAO(new JdbcTemplate(dataSource));
    // }

    // private CouponsDAO couponsDAO; = mock(JdbcTemplate.class);

    // @BeforeEach
    // public void beforeEach() {
    // sequenceRepository = new SequenceRepository(jdbcTemplate);
    // }

    @Test
    public void testList() {
        List<Coupons> listCoupon = couponsDAO.getNewCoupons();
        assertTrue(listCoupon.isEmpty());
    }
}
