package com.backend.webproject.controller;

import java.util.List;

import com.backend.webproject.entity.EntityEvents;
import com.backend.webproject.service.implementation.IServiceEvents;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")
public class ControllerEvents {

    @Autowired
    @Qualifier("eventsIService")
    private IServiceEvents iServiceEvents;

    @GetMapping(path = "/list", produces = { "application/json" })
    public List<EntityEvents> listEvents() {
        return iServiceEvents.listAllEntityEvents();

    }

    @GetMapping(path = "/")
    public String showEventsHome() {
        return "events";
    }
}
