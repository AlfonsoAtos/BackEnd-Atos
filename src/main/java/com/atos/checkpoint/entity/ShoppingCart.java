package com.atos.checkpoint.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @Id
    @Column(name = "shoppingcartid")
    private int shoppingCartID;
  
    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "cartStatus")
    private String cartStatus;

    @Column(name = "userID")
    private int userID;

    public ShoppingCart() {}

    public ShoppingCart(int shoppingCartID, Date creationDate, String cartStatus, int userID) {
        this.shoppingCartID = shoppingCartID;
        this.creationDate = creationDate;
        this.cartStatus = cartStatus;
        this.userID = userID;
    }

    public int getShoppingCartID() {
        return shoppingCartID;
    }

    public void setShoppingCartID(int shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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
