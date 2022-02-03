// package com.backend.webproject.managers;

// import static org.junit.jupiter.api.Assertions.*;

// import com.backend.webproject.dao.CouponsDAO;
// import com.backend.webproject.dao.EventsDAO;
// import com.backend.webproject.entity.Coupons;

// import org.junit.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.jdbc.core.JdbcTemplate;

// import static org.mockito.BDDMockito.given;

// import java.util.List;

// @DataJdbcTest
// class AdminSideManagerTest {

// private AdminSideManager adminSideManager;
// private JdbcTemplate jdbcTemplate;

// @Autowired
// public AdminSideManagerTest(JdbcTemplate jdbcTemplate) {
// this.jdbcTemplate = jdbcTemplate;
// adminSideManager = AdminSideManager(jdbcTemplate);

// }

// @Test
// void showCouponsPageTest() {
// List<Coupons> coupons = adminSideManager.showCouponsPage(Model model);
// }

// }
