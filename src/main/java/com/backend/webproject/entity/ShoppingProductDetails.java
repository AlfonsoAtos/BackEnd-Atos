package com.backend.webproject.entity;

public class ShoppingProductDetails {

    private int shoppingProductDetailsID;
    private int quantity;
    private int shoppingCost;
    private int costAfterApplyingCoupon;
    private int productID;
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
