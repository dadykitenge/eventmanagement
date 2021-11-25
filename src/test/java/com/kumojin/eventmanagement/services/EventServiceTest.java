package com.kumojin.eventmanagement.services;

import com.kumojin.eventmanagement.entities.Event;
import com.kumojin.eventmanagement.repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EventServiceTest {

    private Event event;
    @MockBean
    private EventRepository eventRepository;
    @Autowired
    private EventService eventService;

    @BeforeEach
    void setUp() {
        event = Event.builder()
                .id(1L)
                .eventName("Concert")
                .eventDescription("Gospel Concert : Free entrance")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusHours(4))
                .zoneOffset(ZonedDateTime.now().getOffset())
                .build();
        Mockito.when(eventRepository.save(event)).thenReturn(event);
    }

    @Test
    void saveEvent() {
        Event savedEvent = eventService.saveEvent(event);
        assertNotNull(savedEvent);
    }

    @Test
    void getEvents() {
    }
}