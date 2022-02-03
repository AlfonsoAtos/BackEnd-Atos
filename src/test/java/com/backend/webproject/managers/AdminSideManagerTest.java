package com.backend.webproject.managers;

import static org.junit.jupiter.api.Assertions.*;

import com.backend.webproject.dao.CouponsDAO;
import com.backend.webproject.dao.EventsDAO;
import com.backend.webproject.entity.Coupons;
import com.backend.webproject.entity.Events;

import java.util.Date;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AdminSideManagerTest {

    @Autowired
    private AdminSideManager adminSideManager;

    @Mock
    private CouponsDAO couponsDAO;

    @Mock
    private EventsDAO eventsDAO;

    @Mock
    private Model model;

    private Coupons createCoupon() {
        return new Coupons(1, "Winter", "1234567890", "Open", 40, 1, 1);
    }

    private Events createEvent() {
        return new Events(1, "Event", "Event description", new Date(), new Date(), "Valid", 1);
    }

    @Test
    void showCouponsTest() {
        List<Coupons> coupons = new ArrayList<>();
        coupons.add(createCoupon());
        List<Events> events = new ArrayList<>();
        events.add(createEvent());

        given(couponsDAO.getNewCoupons()).willReturn(coupons);
        given(eventsDAO.getNewEvents()).willReturn(events);

        adminSideManager.showCouponsPage(model);
        adminSideManager.showEventsPage(model);
    }

    @Test
    void searchByCartIDTest() {

        String couponCode = "1234567890";

        List<Coupons> couponsList = new ArrayList<Coupons>();

        given(couponsDAO.validateCoupons(couponCode)).willReturn((Coupons) couponsList);

        assertEquals("coupons", adminSideManager.searchByCartID(couponCode));

    }
}
