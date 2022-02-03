package com.backend.webproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "coupon")
public class Payment {

    @Id
    @Column(name = "paymentID")
    private int paymentID;
    @Column(name = "openCoupon")
    private int openCoupon;
    @Column(name = "shoppingFinalAmount")
    private int shoppingFinalAmount;
    @Column(name = "paymentStatus")
    private String paymentStatus;
    @Column(name = "shoppingCartID")
    private int shoppingCartID;

    public Payment() {

    }

    public Payment(int paymentID, int openCoupon, int shoppingFinalAmount, String paymentStatus, int shoppingCartID) {
        this.paymentID = paymentID;
        this.openCoupon = openCoupon;
        this.shoppingFinalAmount = shoppingFinalAmount;
        this.paymentStatus = paymentStatus;
        this.shoppingCartID = shoppingCartID;
    }

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
