package com.backend.webproject;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import com.backend.webproject.controller.AdminSideController;
import com.backend.webproject.dao.EventsDAO;
import com.backend.webproject.entity.Events;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class EventsTest {

    @MockBean
    EventsDAO eventsDAO = mock(EventsDAO.class);

    @Test
    public void eventsTestList() {
        List<Events> listEvents = eventsDAO.getNewEvents();
        assertTrue(listEvents.isEmpty());
    }

    @Test
    public void eventsTestSearch() {
        eventsDAO.searchEventsById(1);
    }

    @Test
    public void eventsTestInsert() {
        eventsDAO.insertNewEvents(1, "test2022", "Discount test2022", "2022-01-01", "2022-12-31", "Valid", 1);
    }

    @Test
    public void eventsTestUpdate() {
        eventsDAO.updateEvents(1, "test2022", "Discount test2022", "2022-01-01", "2022-12-31", "Valid", 1);
    }

    @Test
    public void eventsTestDelete() {
        eventsDAO.deleteEvents(1);
    }

    @Test
    public void eventsTestAutoId() {
        eventsDAO.getAutoEventsId();
    }

    /* ----- CONTROLLER ----- */

    // @Test
    // public void eventsTestControllerList() {
    // List<Events> listEvents = adminSideController.showEventsPage();
    // assertTrue(listEvents.isEmpty());
    // }
}
