package com.kumojin.eventmanagement.controllers;

import com.kumojin.eventmanagement.entities.Event;
import com.kumojin.eventmanagement.services.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@WebMvcTest(EventController.class)
class EventControllerTest {

    private Event event;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @BeforeEach
    void setUp() {
        event = Event.builder()
                .id(1L)
                .eventName("Concert")
                .eventDescription("Gospel Concert : Free entrance")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusHours(4))
                .zoneOffset("+02:00")
                .build();
    }

    @Test
    void saveEvent() throws Exception {
        Event inputEvent = Event.builder()
                .eventName("Concert")
                .eventDescription("Gospel Concert : Free entrance")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusHours(4))
                .zoneOffset("+02:00")
                .build();
        Mockito.when(eventService.saveEvent(inputEvent)).thenReturn(event);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/events")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "    \"eventName\": \"CONCERT\",\n" +
                "    \"eventDescription\": \"PROFANE\",\n" +
                "    \"startDate\" : \"2019-03-27 02:10:02\",\n" +
                "    \"endDate\" : \"2019-03-01 10:15:01\",\n" +
                "    \"zoneOffset\": \"+02:00\"\n" +
                "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getEvents() {
    }
}