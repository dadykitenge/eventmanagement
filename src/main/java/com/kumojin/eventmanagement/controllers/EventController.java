package com.kumojin.eventmanagement.controllers;

import com.kumojin.eventmanagement.entities.Event;
import com.kumojin.eventmanagement.services.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping(path = "/events")
    public Event saveEvent(@Valid @RequestBody Event event) {

        log.info("Inside saveEvent of EventController");
        if(event.getStartDate().isBefore(event.getEndDate()))
            return eventService.saveEvent(event);
        return eventService.saveEvent(event);

    }

    @GetMapping(path = "/events")
    public List<Event> getEvents() {
        log.info("Inside getEvents of EventController");
        return eventService.getEvents();
    }
}