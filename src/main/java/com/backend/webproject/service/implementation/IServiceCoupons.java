package com.backend.webproject.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.backend.webproject.entity.EntityCoupon;
import com.backend.webproject.repository.RepositoryCoupons;
import com.backend.webproject.repository.RepositoryGetNewCouponsId;
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

    @Autowired
    @Qualifier("getNewCouponsRepository")
    private RepositoryGetNewCouponsId repositoryGetNewCouponId;

    @Override
    public List<EntityCoupon> listAllEntityCoupons() {
        return (List<EntityCoupon>) repositoryCoupons.findAll();
    }

    /* GET By ID */
    @Override
    public Optional<EntityCoupon> findByIdEntityCoupons(int cID) {
        return repositoryCoupons.findById(cID);
    }

    @Override
    public EntityCoupon updateEntityCoupons(EntityCoupon entityCoupon) {
        return repositoryCoupons.save(entityCoupon);
    }

    // @Override
    // public int removeEntityCoupons(int cID) {
    // return repositoryCoupons.deleteByCouponId(cID);
    // }

    @Override
    public EntityCoupon addEntityCoupons(EntityCoupon entityCoupon) {
        int newCouponId = repositoryGetNewCouponId.getNewCouponId().getNewCouponId();
        EntityCoupon new_ = new EntityCoupon();
        new_.setcID(newCouponId);
        new_.setcName(entityCoupon.getcName());
        new_.setcCode(entityCoupon.getcCode());
        new_.setcType(entityCoupon.getcType());
        new_.setcDiscount(entityCoupon.getcDiscount());
        new_.setpEventID(entityCoupon.getpEventID());
        new_.setpCategoryID(entityCoupon.getpCategoryID());

        return repositoryCoupons.save(new_);
    }

}
