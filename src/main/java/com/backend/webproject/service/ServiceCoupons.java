package com.backend.webproject.service;

import java.util.List;
import java.util.Optional;

import com.backend.webproject.entity.EntityCoupon;

public interface ServiceCoupons {

    public abstract List<EntityCoupon> listAllEntityCoupons();

    public abstract Optional<EntityCoupon> findByIdEntityCoupons(int cID);

    public abstract EntityCoupon updateEntityCoupons(EntityCoupon entityCoupon);

    // public abstract int removeEntityCoupons(int cID);

    public abstract EntityCoupon addEntityCoupons(EntityCoupon entityCoupon);

}
