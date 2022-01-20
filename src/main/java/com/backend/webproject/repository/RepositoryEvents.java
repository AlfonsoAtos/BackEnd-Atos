package com.backend.webproject.repository;

import com.backend.webproject.entity.EntityEvents;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("eventsRepository")
public interface RepositoryEvents extends CrudRepository<EntityEvents, Integer> {

}
