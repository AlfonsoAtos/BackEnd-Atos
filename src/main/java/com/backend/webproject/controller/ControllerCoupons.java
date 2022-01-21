package com.backend.webproject.controller;

import java.util.List;
import java.util.Optional;

import com.backend.webproject.entity.EntityCoupon;
import com.backend.webproject.service.implementation.IServiceCoupons;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupons")
@CrossOrigin(origins = "*")
public class ControllerCoupons {

    @Autowired
    @Qualifier("couponsIService")
    private IServiceCoupons iServiceCoupons;

    /* GET http://localhost:8081/coupons/list */
    @GetMapping(path = "/list", produces = { "application/json" })
    public List<EntityCoupon> listCoupons() {

        return iServiceCoupons.listAllEntityCoupons();
    }

    /* GET http://localhost:8081/coupons/get/1 */
    @GetMapping(path = "/get/{cID}", produces = { "application/json" })
    public Optional<EntityCoupon> getEntityCoupons(@PathVariable int cID) {

        return iServiceCoupons.findByIdEntityCoupons(cID);
    }

    /* POST http://localhost:8081/coupons/new */
    @PostMapping(path = "/new", produces = { "application/json" })
    public EntityCoupon newEntityCoupons(@RequestBody EntityCoupon entityCoupon) {

        return iServiceCoupons.addEntityCoupons(entityCoupon);
    }

    /* PUT http://localhost:8081/coupons/update */
    @PutMapping(path = "/update", produces = { "application/json" })
    public EntityCoupon updateEntityCoupons(@RequestBody EntityCoupon entityCoupon) {

        return iServiceCoupons.updateEntityCoupons(entityCoupon);
    }

    /* DELETE http://localhost:8081/coupons/delete/1 */
    // @DeleteMapping(path = "/delete/{cID}", produces = { "application/json" })
    // public int deleteEntityCoupons(@PathVariable int cID) {

    // return iServiceCoupons.removeEntityCoupons(cID);
    // }
}
