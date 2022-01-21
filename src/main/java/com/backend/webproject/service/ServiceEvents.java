package com.backend.webproject.service;

import java.util.*;

import com.backend.webproject.entity.EntityEvents;

public interface ServiceEvents {

    public abstract List<EntityEvents> listAllEntityEvents();

    public abstract Optional<EntityEvents> findByIdEntityEvents(int eventId);

    public abstract EntityEvents addEntityEvents(EntityEvents entityEvents);

    public abstract EntityEvents updateEntityEvents(EntityEvents entityEvents);

    public abstract int removeEntityEvents(int eventId);

}
