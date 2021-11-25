package com.kumojin.eventmanagement.repositories;

import com.kumojin.eventmanagement.entities.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Transactional
class EventRepositoryTest {

    @MockBean
    public TestEntityManager entityManager;

    private Event event;

    @Autowired
    private EventRepository eventRepository;

    @BeforeEach
    void setUp() {
        event = Event.builder()
                .id(1L)
                .eventName("Festival")
                .eventDescription("VIP")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(5))
                .zoneOffset(OffsetDateTime.now().getOffset())
                .build();
        entityManager.persist(event);
    }

    @Test
    public void whenTestCompleteThenPersiste() {
        Event events = eventRepository.save(event);
        assertNotNull(events);
    }
}