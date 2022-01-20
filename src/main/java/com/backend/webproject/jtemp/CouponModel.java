package com.backend.webproject.jtemp;

public class CouponModel {

    int cID;
    String cName;
    String cType;
    int cDiscount;
    int pEventID;
    int pCategoryID;
    String cCode;

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

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

}
