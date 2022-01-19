package com.backend.webproject;

import java.util.*;

import com.backend.mappers.EventsMapper;
import com.backend.models.EventsModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplate {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private EventsMapper eventsMapper;

    public List<EventsModel> getNewEvents() {

        List<EventsModel> newEvents = jdbcTemplate.query(
                "SELECT * FROM (SELECT * FROM Promotionevent ORDER BY promotionEventID DESC)",
                eventsMapper);

        return newEvents;
    }
}
