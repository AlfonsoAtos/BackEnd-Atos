package com.backend.webproject.dao;

import java.util.*;

import com.backend.webproject.entity.Events;
import com.backend.webproject.mappers.EventsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventsDAO {

    @Autowired
    JdbcTemplate temp;

    @Autowired
    private EventsMapper eventsMapper;

    /* GET */
    public List<Events> getNewEvents() {

        String sql = "SELECT * FROM (SELECT * FROM promotionevent ORDER BY promotioneventid DESC) WHERE ROWNUM <= 5";
        List<Events> newEvents = temp.query(sql, eventsMapper);
        return newEvents;
    }

    /* GET By ID */
    public Events searchEventsById(int eventsId) {
        String sql = "SELECT * FROM promotionevent WHERE promotioneventid = ?";
        Events eventsData = (Events) temp.query(sql,  new Object[] {eventsId}, eventsMapper).get(0);
        return eventsData;
    }

    /* POST */
    public void insertNewEvents(int eventsId, String eventsName, String eventsDescription, String eventsStartDate,
        String eventsEndDate, String eventsStatus, int eventsAdminId) {

        String sql = "INSERT INTO promotionevent VALUES(?,?,?,TO_DATE(?, 'YYYY-MM-DD'),TO_DATE(?, 'YYYY-MM-DD'),?,?)";
        temp.update(sql, new Object[] { eventsId, eventsName, eventsDescription, eventsStartDate, eventsEndDate,
                eventsStatus, eventsAdminId });
    }

    /* PUT */
    public void updateEvents(int eventsId, String eventsName, String eventsDescription, String eventsStartDate,
        String eventsEndDate, String eventsStatus, int eventsAdminId) {

        String sql = "UPDATE promotionevent SET promotioneventname = ?, promotioneventdescription = ?, promotioneventstartdate = TO_DATE(?, 'YYYY-MM-DD'), promotioneventenddate = TO_DATE(?, 'YYYY-MM-DD'), promotioneventstatus = ?, adminid = ? WHERE promotioneventid = ?";
        temp.update(sql, new Object[] { eventsName, eventsDescription, eventsStartDate, eventsEndDate,
                eventsStatus, eventsAdminId, eventsId });
    }

    /* DELETE */
    public void deleteEvents(int eventsId) {

        String sql = "DELETE FROM promotionevent WHERE promotioneventid = ?";
        temp.update(sql, new Object[] { eventsId });
    }

    /* AUTO INCREMENT for ID */
    public int getAutoEventsId() {
        int newEventsId = temp.queryForObject("SELECT MAX(promotioneventid) + 1 FROM promotionevent", Integer.class);
        return newEventsId;
    }
}
