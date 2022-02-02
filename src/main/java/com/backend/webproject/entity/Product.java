package com.backend.webproject.entity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Product {
    int pID;
    String pName;
    String pCompany;
    float pPrice;
    String pDescription;
    String pImagePath;
    int pCategoryID;
    
    String pFormattedPrice;

    public Product() {}

    public Product(int pID, String pName, String pCompany, float pPrice, String pDescription, String pImagePath, int pCategoryID) {
        this.pID = pID;
        this.pName = pName;
        this.pCompany = pCompany;
        this.pPrice = pPrice;
        this.pDescription = pDescription;
        this.pImagePath = pImagePath;
        this.pCategoryID = pCategoryID;
    }

    public String formatPrice(float price) {
        NumberFormat priceFormatter = new DecimalFormat("#0.00");
        return priceFormatter.format(price);
    }

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

    public String getPFormattedPrice() {
        return this.pFormattedPrice;
    }

    public void setPFormattedPrice(String pFormattedPrice) {
        this.pFormattedPrice = pFormattedPrice;
    }
    
}
