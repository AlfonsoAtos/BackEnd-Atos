package com.backend.webproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingproductdetails")
public class ShoppingProductDetails {

    @Id
    @Column(name = "shoppingproductdetailsid")
    private int shoppingProductDetailsID;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "shoppingCost")
    private int shoppingCost;
    @Column(name = "costAfterApplyingCoupon")
    private int costAfterApplyingCoupon;
    @Column(name = "productID")
    private int productID;
    @Column(name = "shoppingCartID")
    private int shoppingCartID;
    
    public int getShoppingCartID() {
        return shoppingCartID;
    }
    public int getShoppingProductDetailsID() {
        return shoppingProductDetailsID;
    }
    public void setShoppingProductDetailsID(int shoppingProductDetailsID) {
        this.shoppingProductDetailsID = shoppingProductDetailsID;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getShoppingCost() {
        return shoppingCost;
    }
    public void setShoppingCost(int shoppingCost) {
        this.shoppingCost = shoppingCost;
    }
    public int getCostAfterApplyingCoupon() {
        return costAfterApplyingCoupon;
    }
    public void setCostAfterApplyingCoupon(int costAfterApplyingCoupon) {
        this.costAfterApplyingCoupon = costAfterApplyingCoupon;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public void setShoppingCartID(int shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }


}
