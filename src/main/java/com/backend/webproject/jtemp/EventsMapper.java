package com.backend.webproject.jtemp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.backend.webproject.entity.Events;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EventsMapper implements RowMapper {

    @Override
    public Events mapRow(ResultSet result, int arg1) throws SQLException {
        Events objEvents = new Events();
        objEvents.setEventsId(result.getInt(1));
        objEvents.setEventsName(result.getString(2));
        objEvents.setEventsDescription(result.getString(3));
        objEvents.setEventsStartDate(result.getDate(4));
        objEvents.setEventsEndDate(result.getDate(5));
        objEvents.setEventsStatus(result.getString(6));
        objEvents.setEventsAdminId(result.getInt(7));
        return objEvents;
    }

}
