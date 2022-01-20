package com.backend.webproject.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import com.backend.webproject.entity.EntityCoupon;
import com.backend.webproject.repository.RepositoryCoupons;
import com.backend.webproject.service.ServiceCoupons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("couponsIService")
@Transactional
public class IServiceCoupons implements ServiceCoupons {

    @Autowired
    @Qualifier("couponsRepository")
    private RepositoryCoupons repositoryCoupons;

    @Override
    public List<EntityCoupon> listAllEntityCoupons() {
        // TODO Auto-generated method stub
        return (List<EntityCoupon>) repositoryCoupons.findAll();
    }

}
