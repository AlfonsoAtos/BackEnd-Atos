package com.backend.controllers;

import java.util.List;

import com.backend.interfaceService.IEventsService;
import com.backend.models.EventsModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private IEventsService serviceEvents;

    @GetMapping("/list")
    public String list(Model model) {
        List<EventsModel> events = serviceEvents.list();
        model.addAttribute("events", events);
        return "index";
    }
}
