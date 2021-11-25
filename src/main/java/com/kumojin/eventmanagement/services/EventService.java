package com.kumojin.eventmanagement.services;

import com.kumojin.eventmanagement.entities.Event;

import java.util.List;

public interface EventService {

    Event saveEvent(Event event);

    List<Event> getEvents();
}
