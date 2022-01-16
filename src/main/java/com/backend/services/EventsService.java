package com.backend.services;

import java.util.List;
import java.util.Optional;

import com.backend.interfaceService.IEventsService;
import com.backend.interfaces.IEvents;
import com.backend.models.EventsModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsService implements IEventsService {

    @Autowired
    private IEvents dataEvents;

    @Override
    public List<EventsModel> list() {
        return (List<EventsModel>) dataEvents.findAll();
    }

    @Override
    public Optional<EventsModel> listId(int eventId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int save(EventsModel em) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(int eventId) {
        // TODO Auto-generated method stub

    }

}
