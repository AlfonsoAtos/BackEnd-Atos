package com.backend.webproject.jtemp;

public class Payment {

    private int paymentID;
    private int openCoupon;
    private int shoppingFinalAmount;
    private String paymentStatus;
    private int shoppingCartID;

    
    public int getShoppingCartID() {
        return shoppingCartID;
    }
    public int getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
    public int getOpenCoupon() {
        return openCoupon;
    }
    public void setOpenCoupon(int openCoupon) {
        this.openCoupon = openCoupon;
    }
    public int getShoppingFinalAmount() {
        return shoppingFinalAmount;
    }
    public void setShoppingFinalAmount(int shoppingFinalAmount) {
        this.shoppingFinalAmount = shoppingFinalAmount;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public void setShoppingCartID(int shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }
    
}
