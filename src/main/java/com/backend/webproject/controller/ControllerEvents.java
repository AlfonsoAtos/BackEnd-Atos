package com.backend.webproject.controller;

import java.util.List;
import java.util.Optional;

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

    /* GET http://localhost:8081/events/list */
    @GetMapping(path = "/list", produces = { "application/json" })
    public List<EntityEvents> listEvents() {

        return iServiceEvents.listAllEntityEvents();
    }

    /* GET http://localhost:8081/events/get/1 */
    @GetMapping(path = "/get/{eventId}", produces = { "application/json" })
    public Optional<EntityEvents> getEntityEvents(@PathVariable int eventId) {

        return iServiceEvents.findByIdEntityEvents(eventId);
    }

    /* POST http://localhost:8081/events/new */
    @PostMapping(path = "/new", produces = { "application/json" })
    public EntityEvents newEntityEvents(@RequestBody EntityEvents entityEvents) {

        return iServiceEvents.addEntityEvents(entityEvents);
    }

    /* PUT http://localhost:8081/events/update */
    @PutMapping(path = "/update", produces = { "application/json" })
    public EntityEvents updateEntityEvents(@RequestBody EntityEvents entityEvents) {

        return iServiceEvents.updateEntityEvents(entityEvents);
    }

    /* DELETE http://localhost:8081/events/delete/1 */
    @DeleteMapping(path = "/delete/{eventId}", produces = { "application/json" })
    public int deleteEntityEvents(@PathVariable int eventId) {

        return iServiceEvents.removeEntityEvents(eventId);
    }
}
