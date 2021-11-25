package com.kumojin.eventmanagement.repositories;

import com.kumojin.eventmanagement.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
