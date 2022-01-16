package com.backend.interfaces;

import com.backend.models.EventsModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvents extends CrudRepository<EventsModel, Integer> {

}
