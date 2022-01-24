package com.backend.webproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "coupon")
public class EntityCoupon {

    @Id
    @Column(name = "couponID")
    int cID;

    @Column(name = "couponName")
    String cName;

    @Column(name = "couponCode")
    String cCode;

    @Column(name = "couponType")
    String cType;

    @Column(name = "couponDiscount")
    int cDiscount;

    @Column(name = "promotionEventID")
    int pEventID;

    @Column(name = "productCategoryID")
    int pCategoryID;

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public int getcDiscount() {
        return cDiscount;
    }

    public void setcDiscount(int cDiscount) {
        this.cDiscount = cDiscount;
    }

    public int getpEventID() {
        return pEventID;
    }

    public void setpEventID(int pEventID) {
        this.pEventID = pEventID;
    }

    public int getpCategoryID() {
        return pCategoryID;
    }

    public void setpCategoryID(int pCategoryID) {
        this.pCategoryID = pCategoryID;
    }

}
