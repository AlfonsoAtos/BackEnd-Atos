package com.backend.webproject.jtemp;

public class ProductsModel {
    int pID;
    String pName;
    String pCompany;
    float pPrice;
    String pDescription;
    String pImagePath;
    int pCategoryID;

    public int getPID() {
        return this.pID;
    }

    public void setPID(int pID) {
        this.pID = pID;
    }

    public String getPName() {
        return this.pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPCompany() {
        return this.pCompany;
    }

    public void setPCompany(String pCompany) {
        this.pCompany = pCompany;
    }

    public float getPPrice() {
        return this.pPrice;
    }

    public void setPPrice(float pPrice) {
        this.pPrice = pPrice;
    }

    public String getPDescription() {
        return this.pDescription;
    }

    public void setPDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getPImagePath() {
        return this.pImagePath;
    }

    public void setPImagePath(String pImagePath) {
        this.pImagePath = pImagePath;
    }

    public int getPCategoryID() {
        return this.pCategoryID;
    }

    public void setPCategoryID(int pCategoryID) {
        this.pCategoryID = pCategoryID;
    }
}
