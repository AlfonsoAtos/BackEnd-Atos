package com.backend.webproject.repository;

import com.backend.webproject.entity.GetNewEventId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("getNewEventRepository")
public interface RepositoryGetNewEventId extends CrudRepository<GetNewEventId, Integer> {

    @Query(value = "SELECT PROMOTIONEVENTID newEventId, PROMOTIONEVENTNAME, PROMOTIONEVENTDESCRIPTION, PROMOTIONEVENTSTARTDATE, PROMOTIONEVENTENDDATE, PROMOTIONEVENTSTATUS, ADMINID FROM PROMOTIONEVENT", nativeQuery = true)
    GetNewEventId getNewEventId();
}
