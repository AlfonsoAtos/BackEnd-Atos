package com.backend.webproject.controller;

import com.backend.webproject.jtemp.Coupons;
import com.backend.webproject.jtemp.JdbcTemplateCoupons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin-side")
public class AdminSideController {

    @Autowired
    JdbcTemplateCoupons jdbcTemplateCoupons;

    @RequestMapping("/")
    public String showAdminPage(Model model) {
        List<Coupons> newCoupons = jdbcTemplateCoupons.getNewCoupons();
        model.addAttribute("newCoupons", newCoupons);
        return "admin";
    }
}
