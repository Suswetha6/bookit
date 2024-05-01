package org.abhinavgpt.bookit.services.event;

import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.modals.Event;

public interface EventService {
    Event getEvent(long eventId) throws EventNotFoundException;
    Event updateEvent(Event event);
}
