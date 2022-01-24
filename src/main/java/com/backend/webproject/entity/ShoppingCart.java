package com.backend.webproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @Id
    @Column(name = "paymentID")
    private int shoppingCartID;

    @Column(name = "creationDate")
    private String creationDate;

    @Column(name = "cartStatus")
    private String cartStatus;

    @Column(name = "userID")
    private int userID;

    public int getShoppingCartID() {
        return shoppingCartID;
    }

    public void setShoppingCartID(int shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    
}
