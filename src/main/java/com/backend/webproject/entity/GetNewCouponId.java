package com.backend.webproject.entity;

import javax.persistence.*;

@Entity
public class GetNewCouponId {
    @Id
    private int newCouponId;

    public int getNewCouponId() {
        return newCouponId;
    }

    public void setNewCouponId(int newCouponId) {
        this.newCouponId = newCouponId;
    }

}
