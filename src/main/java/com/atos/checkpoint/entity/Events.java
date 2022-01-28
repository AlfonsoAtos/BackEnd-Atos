package com.atos.checkpoint.entity;

import java.util.Date;

public class Events {

    int eventsId;
    String eventsName;
    String eventsDescription;
    Date eventsStartDate;
    Date eventsEndDate;
    String eventsStatus;
    int eventsAdminId;

    public int getEventsId() {
        return eventsId;
    }

    public void setEventsId(int eventsId) {
        this.eventsId = eventsId;
    }

    public String getEventsName() {
        return eventsName;
    }

    public void setEventsName(String eventsName) {
        this.eventsName = eventsName;
    }

    public String getEventsDescription() {
        return eventsDescription;
    }

    public void setEventsDescription(String eventsDescription) {
        this.eventsDescription = eventsDescription;
    }

    public Date getEventsStartDate() {
        return eventsStartDate;
    }

    public void setEventsStartDate(Date eventsStartDate) {
        this.eventsStartDate = eventsStartDate;
    }

    public Date getEventsEndDate() {
        return eventsEndDate;
    }

    public void setEventsEndDate(Date eventsEndDate) {
        this.eventsEndDate = eventsEndDate;
    }

    public String getEventsStatus() {
        return eventsStatus;
    }

    public void setEventsStatus(String eventsStatus) {
        this.eventsStatus = eventsStatus;
    }

    public int getEventsAdminId() {
        return eventsAdminId;
    }

    public void setEventsAdminId(int eventsAdminId) {
        this.eventsAdminId = eventsAdminId;
    }

}
