package com.backend.webproject.controller;

import com.backend.webproject.jtemp.Coupons;
import com.backend.webproject.jtemp.Events;
import com.backend.webproject.jtemp.JdbcTemplateCoupons;
import com.backend.webproject.jtemp.JdbcTemplateEvents;

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

    @Autowired
    JdbcTemplateEvents jdbcTemplateEvents;

    @RequestMapping("/")
    public String showAdminPage() {
        return "admin";
    }

    @RequestMapping("/coupons")
    public String showCouponsPage(Model model) {
        List<Coupons> newCoupons = jdbcTemplateCoupons.getNewCoupons();
        model.addAttribute("newCoupons", newCoupons);
        return "coupons";
    }

    @RequestMapping("/events")
    public String showEventsPage(Model model) {
        List<Events> newEvents = jdbcTemplateEvents.getNewEvents();
        model.addAttribute("newEvents", newEvents);
        return "events";
    }
}
