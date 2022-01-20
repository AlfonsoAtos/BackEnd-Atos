package com.backend.webproject.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.backend.webproject.entity.EntityEvents;
import com.backend.webproject.repository.RepositoryEvents;
import com.backend.webproject.repository.RepositoryGetNewEventId;
import com.backend.webproject.service.ServiceEvents;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service("eventsIService")
@Transactional
public class IServiceEvents implements ServiceEvents {

    @Autowired
    @Qualifier("eventsRepository")
    private RepositoryEvents repositoryEvents;

    @Autowired
    @Qualifier("getNewEventRepository")
    private RepositoryGetNewEventId repositoryGetNewEventId;

    /* GET All list */
    @Override
    public List<EntityEvents> listAllEntityEvents() {
        // TODO Auto-generated method stub
        return (List<EntityEvents>) repositoryEvents.findAll();
    }

    /* GET By ID */
    @Override
    public Optional<EntityEvents> findByIdEntityEvents(int eventId) {
        // TODO Auto-generated method stub
        return repositoryEvents.findById(eventId);
    }

    /* POST Add a field */
    @Override
    public EntityEvents addEntityEvents(EntityEvents entityEvents) {
        // TODO Auto-generated method stub
        int newEventId = repositoryGetNewEventId.getNewEventId().getNewEventId();
        EntityEvents new_ = new EntityEvents();
        new_.setEventId(newEventId);
        new_.setEventName(entityEvents.getEventName());
        new_.setEventDescription(entityEvents.getEventDescription());
        new_.setEventStartDate(entityEvents.getEventStartDate());
        new_.setEventEndDate(entityEvents.getEventEndDate());
        new_.setEventStatus(entityEvents.getEventStatus());
        new_.setEventAdminId(entityEvents.getEventAdminId());

        return repositoryEvents.save(new_);
    }

    /* PUT Edit all or one field */
    @Override
    public EntityEvents updateEntityEvents(EntityEvents entityEvents) {
        // TODO Auto-generated method stub
        return repositoryEvents.save(entityEvents);
    }

    /* DELETE Remove a field */
    @Override
    public int removeEntityEvents(int eventId) {
        // TODO Auto-generated method stub
        return repositoryEvents.deleteByEventId(eventId);
    }
}
