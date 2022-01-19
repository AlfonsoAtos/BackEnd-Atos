package com.backend.controllers;

import java.util.List;

import com.backend.models.EventsModel;
import com.backend.webproject.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventsController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        List<EventsModel> newEvents = jdbcTemplate.getNewEvents();
        model.addAttribute("newEvents", newEvents);
        return "index";
    }
}
