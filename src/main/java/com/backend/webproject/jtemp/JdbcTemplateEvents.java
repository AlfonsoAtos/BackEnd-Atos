package com.backend.webproject.jtemp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateEvents {

    JdbcTemplate temp;

    public JdbcTemplateEvents(JdbcTemplate temp) {
        this.temp = temp;
    }

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private EventsMapper eventsMapper;

    /* GET */
    public List<Events> getNewEvents() {

        String sql = "SELECT * FROM (SELECT * FROM promotionevent ORDER BY promotioneventid DESC) WHERE ROWNUM <= 5";
        List<Events> newEvents = jdbcTemplate.query(sql, eventsMapper);
        return newEvents;
    }

    /* POST */
    public void insertNewEvents(int eventsId, String eventsName, String eventsDescription, Date eventsStartDate,
            Date eventsEndDate, String eventsStatus, int eventsAdminId) {

        String sql = "INSERT INTO promotionevent VALUES(?,?,?,TO_DATE(?, 'YYYY-MM-DD'),TO_DATE(?, 'YYYY-MM-DD'),?,?);";
        temp.update(sql, new Object[] { eventsId, eventsName, eventsDescription, eventsStartDate, eventsEndDate,
                eventsStatus, eventsAdminId });
    }

    /* PUT */
    public void updateEmployee(int eventsId, String eventsName, String eventsDescription, Date eventsStartDate,
            Date eventsEndDate, String eventsStatus, int eventsAdminId) {

        String sql = "UPDATE promotionevent SET promotioneventname = ?, promotioneventdescription = ?, promotioneventstardate = ?, promotioneventenddate = ?, promotioneventstatus = ?, adminid = ? WHERE promotioneventid = ?";
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
