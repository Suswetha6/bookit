package org.abhinavgpt.bookit.services.event;

import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.modals.Event;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public Event getEvent(long eventId) throws EventNotFoundException {
        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }
}
