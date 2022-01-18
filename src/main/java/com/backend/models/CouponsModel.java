package com.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "coupon")
public class CouponsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int couponId;
    private String couponName;
    private String couponCode;
    private String couponType;
    private int couponDiscount;
    private int promotionalEventId;
    private int productCategoryId;

    public CouponsModel() {

    }

    public CouponsModel(int couponId, String couponName, String couponCode, String couponType, int couponDiscount,
            int promotionalEventId, int productCategoryId) {
        this.couponId = couponId;
        this.couponName = couponName;
        this.couponCode = couponCode;
        this.couponType = couponType;
        this.couponDiscount = couponDiscount;
        this.promotionalEventId = promotionalEventId;
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

    public int getPromotionalEventId() {
        return promotionalEventId;
    }

    public void setPromotionalEventId(int promotionalEventId) {
        this.promotionalEventId = promotionalEventId;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

}
