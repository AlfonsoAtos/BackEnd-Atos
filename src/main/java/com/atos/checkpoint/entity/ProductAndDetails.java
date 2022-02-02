package com.atos.checkpoint.entity;

public class ProductAndDetails {
    
    private Product product;
    private ShoppingProductDetails spd;
    
    public Product getProduct() {
        return product;
    }
    public ShoppingProductDetails getSpd() {
        return spd;
    }
    public void setSpd(ShoppingProductDetails spd) {
        this.spd = spd;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
