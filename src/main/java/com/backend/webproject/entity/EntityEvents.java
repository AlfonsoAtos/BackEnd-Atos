package com.backend.webproject.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "promotionevent")
public class EntityEvents {

    @Id
    @Column(name = "promotionEventID")
    private int eventId;

    @Column(name = "promotionEventName")
    private String eventName;

    @Column(name = "promotionEventDescription")
    private String eventDescription;

    @Column(name = "promotionEventStartDate")
    private Date eventStartDate;

    @Column(name = "promotionEventEndDate")
    private Date eventEndDate;

    @Column(name = "promotionEventStatus")
    private String eventStatus;

    @Column(name = "adminID")
    private int eventAdminId;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public int getEventAdminId() {
        return eventAdminId;
    }

    public void setEventAdminId(int eventAdminId) {
        this.eventAdminId = eventAdminId;
    }

}
