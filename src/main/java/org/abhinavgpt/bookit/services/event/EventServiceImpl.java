package org.abhinavgpt.bookit.services.event;

import org.abhinavgpt.bookit.dtos.EventDTO;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.modals.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Override
    public List<Event> getAllEvents() {
        return List.of();
    }

    @Override
    public Event getEvent(long eventId) throws EventNotFoundException {
        return null;
    }

    @Override
    public Event addEvent(EventDTO event) {
        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public void deleteEventById(long eventId) {

    }
}
