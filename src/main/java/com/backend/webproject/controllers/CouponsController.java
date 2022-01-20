package com.backend.webproject.controllers;

import java.util.List;

import com.backend.webproject.jtemp.CouponModel;
import com.backend.webproject.jtemp.JdbcTemplateCoupons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CouponsController {

    @Autowired
    JdbcTemplateCoupons jdbcTemplateCoupons;

    @RequestMapping("/coupons")
    public String showCouponsPage(Model model) {
        List<CouponModel> newCoupons = jdbcTemplateCoupons.getNewCoupons();
        model.addAttribute("newCoupons", newCoupons);
        return "coupons";
    }
}
