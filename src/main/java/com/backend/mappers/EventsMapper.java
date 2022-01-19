package com.backend.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.backend.models.EventsModel;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EventsMapper implements RowMapper<EventsModel> {

    @Override
    public EventsModel mapRow(ResultSet result, int arg1) throws SQLException {

        EventsModel objEm = new EventsModel();
        objEm.setPromotionEventID(result.getInt(1));
        objEm.setPromotionEventName(result.getString(2));
        objEm.setPromotionEventDescription(result.getString(3));
        objEm.setPromotionEventStartDate(result.getDate(4));
        objEm.setPromotionEventEndDate(result.getDate(5));
        objEm.setPromotionEventStatus(result.getString(6));
        objEm.setAdminID(result.getInt(7));
        return objEm;
    }
}
