package org.abhinavgpt.bookit.repositories;

import org.abhinavgpt.bookit.modals.CinemaHall;
import org.abhinavgpt.bookit.modals.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long>
{
//    findAllByCinemaHallAndEventTimeBetween(CinemaHall cinemaHall, LocalDateTime startTime, LocalDateTime endTime);
    List<Event> findByStartTimeBetweenAndCinemaHall(LocalDateTime startTime, LocalDateTime endTime, CinemaHall cinemaHall);

}
