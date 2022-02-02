package com.backend.webproject.entity;

public class Coupons {

    int couponId;
    String couponName;
    String couponCode;
    String couponType;
    int couponDiscount;
    int promotionEventId;
    int productCategoryId;

    public Coupons() {

    }

    public Coupons(int couponId, String couponName, String couponCode, String couponType, int couponDiscount,
            int promotionEventId, int productCategoryId) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.couponCode = couponCode;
        this.couponType = couponType;
        this.couponDiscount = couponDiscount;
        this.promotionEventId = promotionEventId;
        this.productCategoryId = productCategoryId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public int getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(int couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public int getPromotionEventId() {
        return promotionEventId;
    }

    public void setPromotionEventId(int promotionEventId) {
        this.promotionEventId = promotionEventId;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

}
