package com.backend.controllers;

import java.util.List;

import com.backend.interfaceService.ICouponsService;
import com.backend.models.CouponsModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CouponsController {

    @Autowired
    private ICouponsService serviceCoupons;

    @GetMapping("/list")
    public String list(Model model) {
        List<CouponsModel> coupons = serviceCoupons.list();
        model.addAttribute("coupons", coupons);
        return "index";
    }
}
