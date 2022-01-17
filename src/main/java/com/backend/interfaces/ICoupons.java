package com.backend.interfaces;

import com.backend.models.CouponsModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoupons extends CrudRepository<CouponsModel, Integer> {

}
