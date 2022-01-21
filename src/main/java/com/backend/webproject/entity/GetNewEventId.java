package com.backend.webproject.entity;

import javax.persistence.*;

@Entity
public class GetNewEventId {

    @Id
    private int newEventId;

    public int getNewEventId() {
        return newEventId;
    }

    public void setNewEventId(int newEventId) {
        this.newEventId = newEventId;
    }

}
