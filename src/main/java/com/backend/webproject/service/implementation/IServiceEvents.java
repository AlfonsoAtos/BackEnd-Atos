package com.backend.webproject.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import com.backend.webproject.entity.EntityEvents;
import com.backend.webproject.repository.RepositoryEvents;
import com.backend.webproject.service.ServiceEvents;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service("eventsIService")
@Transactional
public class IServiceEvents implements ServiceEvents {

    @Autowired
    @Qualifier("eventsRepository")
    private RepositoryEvents repositoryEvents;

    @Override
    public List<EntityEvents> listAllEntityEvents() {
        // TODO Auto-generated method stub
        return (List<EntityEvents>) repositoryEvents.findAll();
    }

}
