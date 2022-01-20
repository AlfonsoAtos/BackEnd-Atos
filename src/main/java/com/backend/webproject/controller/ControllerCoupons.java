package com.backend.webproject.controller;

import java.util.List;

import com.backend.webproject.entity.EntityCoupon;
import com.backend.webproject.service.implementation.IServiceCoupons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupons")
@CrossOrigin(origins = "*")
public class ControllerCoupons {

    @Autowired
    @Qualifier("couponsIService")
    private IServiceCoupons iServiceCoupons;

    @GetMapping(path = "/list", produces = { "application/json" })
    public List<EntityCoupon> listCoupons() {
        return iServiceCoupons.listAllEntityCoupons();

    }
}
