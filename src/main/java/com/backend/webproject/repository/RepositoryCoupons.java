package com.backend.webproject.repository;

import com.backend.webproject.entity.EntityCoupon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("couponsRepository")
public interface RepositoryCoupons extends CrudRepository<EntityCoupon, Integer> {

}