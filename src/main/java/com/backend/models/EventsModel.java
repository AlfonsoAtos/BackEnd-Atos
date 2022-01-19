package com.backend.models;

import java.util.Date;

public class EventsModel {

    int promotionEventID;
    String promotionEventName;
    String promotionEventDescription;
    Date promotionEventStartDate;
    Date promotionEventEndDate;
    String promotionEventStatus;
    int adminID;

    public int getPromotionEventID() {
        return promotionEventID;
    }

    public void setPromotionEventID(int promotionEventID) {
        this.promotionEventID = promotionEventID;
    }

    public String getPromotionEventName() {
        return promotionEventName;
    }

    public void setPromotionEventName(String promotionEventName) {
        this.promotionEventName = promotionEventName;
    }

    public String getPromotionEventDescription() {
        return promotionEventDescription;
    }

    public void setPromotionEventDescription(String promotionEventDescription) {
        this.promotionEventDescription = promotionEventDescription;
    }

    public Date getPromotionEventStartDate() {
        return promotionEventStartDate;
    }

    public void setPromotionEventStartDate(Date promotionEventStartDate) {
        this.promotionEventStartDate = promotionEventStartDate;
    }

    public Date getPromotionEventEndDate() {
        return promotionEventEndDate;
    }

    public void setPromotionEventEndDate(Date promotionEventEndDate) {
        this.promotionEventEndDate = promotionEventEndDate;
    }

    public String getPromotionEventStatus() {
        return promotionEventStatus;
    }

    public void setPromotionEventStatus(String promotionEventStatus) {
        this.promotionEventStatus = promotionEventStatus;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

}
