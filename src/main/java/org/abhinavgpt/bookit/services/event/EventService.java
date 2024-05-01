package org.abhinavgpt.bookit.services.event;

import org.abhinavgpt.bookit.dtos.EventDTO;
import org.abhinavgpt.bookit.exceptions.CinemaHallNotFoundException;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.exceptions.InvalidTimeSelectionException;
import org.abhinavgpt.bookit.exceptions.MovieNotFoundException;
import org.abhinavgpt.bookit.modals.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    Event getEvent(long eventId) throws EventNotFoundException;

    Event addEvent(EventDTO event) throws MovieNotFoundException, CinemaHallNotFoundException, InvalidTimeSelectionException;

    Event updateEvent(Event event);

    void deleteEventById(long eventId);
}
