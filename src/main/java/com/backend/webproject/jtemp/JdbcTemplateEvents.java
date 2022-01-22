package com.backend.webproject.jtemp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplateEvents {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private EventsMapper eventsMapper;

    public List<Events> getNewEvents() {
        List<Events> newEvents = jdbcTemplate.query(
                "SELECT * FROM (SELECT * FROM promotionevent ORDER BY promotioneventid DESC) WHERE ROWNUM <= 5",
                eventsMapper);
        return newEvents;
    }
}
