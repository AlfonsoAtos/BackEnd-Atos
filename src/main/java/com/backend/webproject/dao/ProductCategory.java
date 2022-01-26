package com.backend.webproject.dao;

public class ProductCategory {
    int pcID;
    String pcName;
    String pcDescription;

    public int getPcID() {
        return this.pcID;
    }

    public void setPcID(int pcID) {
        this.pcID = pcID;
    }

    public String getPcName() {
        return this.pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getPcDescription() {
        return this.pcDescription;
    }

    public void setPcDescription(String pcDescription) {
        this.pcDescription = pcDescription;
    }
}
