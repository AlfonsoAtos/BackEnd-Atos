// package com.backend.webproject;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// import java.util.List;

// import com.backend.webproject.entity.Coupons;
// import com.backend.webproject.jtemp.JdbcTemplateCoupons;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

// class CouponsTest {

// JdbcTemplateCoupons dao;

// @BeforeEach
// void setUp() throws Exception {
// DriverManagerDataSource dataSource = new DriverManagerDataSource();
// dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
// dataSource.setUsername("system");
// dataSource.setPassword("edu511");
// dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");

// dao = new JdbcTemplateCoupons(new JdbcTemplate(dataSource));
// }

// @Test
// public void testList() {
// List<Coupons> listCoupon = dao.getNewCoupons();
// assertTrue(listCoupon.isEmpty());
// }
// }
