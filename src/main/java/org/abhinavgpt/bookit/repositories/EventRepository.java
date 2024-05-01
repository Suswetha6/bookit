package org.abhinavgpt.bookit.repositories;

import org.abhinavgpt.bookit.modals.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>
{

}
