package org.abhinavgpt.bookit.controllers;

import org.abhinavgpt.bookit.dtos.EventDTO;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.modals.Event;
import org.abhinavgpt.bookit.services.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody EventDTO eventDTO) {
        Event newEvent = eventService.addEvent(eventDTO);
        return ResponseEntity.ok(newEvent);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id, @RequestBody Event Updatedevent) {
        Event event = eventService.updateEvent(Updatedevent);
        return ResponseEntity.ok(event);
    }

    @GetMapping()
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> event = eventService.getAllEvents();
        return ResponseEntity.ok(event);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable long id) throws EventNotFoundException {
        Event event = eventService.getEvent(id);

        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable long id) {
        eventService.deleteEventById((int) id);
        return ResponseEntity.ok("Event deleted successfully.");
    }

}
