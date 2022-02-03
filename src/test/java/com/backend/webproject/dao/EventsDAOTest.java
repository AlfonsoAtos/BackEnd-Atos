package com.backend.webproject.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.backend.webproject.entity.Events;
import com.backend.webproject.mappers.EventsMapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class EventsDAOTest {

	@InjectMocks
	EventsDAO eventsDAO;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private EventsMapper eventsMapper;

	private Events createEvent() {
		return new Events(1, "Event", "Event description", new Date(), new Date(), "Valid", 1);
	}

	@Test
	public void eventsTestList() {
		List<Events> listEvents = eventsDAO.getNewEvents();
		assertTrue(listEvents.isEmpty());
	}

	@Test
	public void eventsTestSearch() {
		Events event = createEvent();
		List<Events> eventsList = new ArrayList<Events>();
		eventsList.add(event);
		given(jdbcTemplate.query(
				"SELECT * FROM promotionevent WHERE promotioneventid = ?",
				new Object[] { event.getEventsId() },
				eventsMapper))
						.willReturn(eventsList);

		Events result = eventsDAO.searchEventsById(event.getEventsId());
		assertEquals(event, result);
	}

	@Test
	public void eventsTestInsert() {
		Events event = createEvent();

		given(jdbcTemplate.update(
				"INSERT INTO promotionevent VALUES(?,?,?,TO_DATE(?, 'YYYY-MM-DD'),TO_DATE(?, 'YYYY-MM-DD'),?,?)",
				new Object[] {
						event.getEventsId(),
						event.getEventsName(),
						event.getEventsDescription(),
						event.getEventsStartDate().toString(),
						event.getEventsEndDate().toString(),
						event.getEventsStatus(),
						event.getEventsAdminId()
				}))
						.willReturn(1);

		int result = eventsDAO.insertNewEvents(
				event.getEventsId(),
				event.getEventsName(),
				event.getEventsDescription(),
				event.getEventsStartDate().toString(),
				event.getEventsEndDate().toString(),
				event.getEventsStatus(),
				event.getEventsAdminId());
		assertEquals(1, result);
	}

	@Test
	public void eventsTestUpdate() {
		Events event = createEvent();
		event.setEventsName("Event name");

		given(jdbcTemplate.update(
				"UPDATE promotionevent SET promotioneventname = ?, promotioneventdescription = ?, promotioneventstartdate = TO_DATE(?, 'YYYY-MM-DD'), promotioneventenddate = TO_DATE(?, 'YYYY-MM-DD'), promotioneventstatus = ?, adminid = ? WHERE promotioneventid = ?",
				new Object[] {
						event.getEventsName(),
						event.getEventsDescription(),
						event.getEventsStartDate().toString(),
						event.getEventsEndDate().toString(),
						event.getEventsStatus(),
						event.getEventsAdminId(),
						event.getEventsId()
				}))
						.willReturn(1);

		int result = eventsDAO.updateEvents(
				event.getEventsId(),
				"Event name",
				event.getEventsDescription(),
				event.getEventsStartDate().toString(),
				event.getEventsEndDate().toString(),
				event.getEventsStatus(),
				event.getEventsAdminId());

		assertEquals(1, result);
	}

	@Test
	public void eventsTestDelete() {
		given(jdbcTemplate.update(
				"DELETE FROM promotionevent WHERE promotioneventid = ?",
				new Object[] { 2 }))
						.willReturn(1);

		int result = eventsDAO.deleteEvents(2);
		assertEquals(1, result);
	}

	@Test
	public void eventsTestAutoId() {
		given(jdbcTemplate.queryForObject(
				"SELECT MAX(promotioneventid) + 1 FROM promotionevent",
				Integer.class))
						.willReturn(3);

		int result = eventsDAO.getAutoEventsId();
		assertEquals(3, result);
	}
}
