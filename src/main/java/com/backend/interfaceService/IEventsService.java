package com.backend.interfaceService;

import java.util.*;

import com.backend.models.EventsModel;

public interface IEventsService {
    public List<EventsModel> list();

    public Optional<EventsModel> listId(int eventId);

    public int save(EventsModel em);

    public void delete(int eventId);
}
