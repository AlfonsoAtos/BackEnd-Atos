package com.backend.webproject.repository;

import com.backend.webproject.entity.GetNewCouponId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("getNewCouponsRepository")
public interface RepositoryGetNewCouponsId extends CrudRepository<GetNewCouponId, Integer> {
    @Query(value = "SELECT COUPON.COUPONID newId FROM COUPON", nativeQuery = true)
    GetNewCouponId getNewCouponId();
}
