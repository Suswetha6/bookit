package org.abhinavgpt.bookit.controllers;

import org.abhinavgpt.bookit.modals.Event;
import org.abhinavgpt.bookit.services.event.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EventController {
    private EventService eventService;

    // add
    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event newEvent = EventService.addEvent(event);
        return ResponseEntity.ok(newEvent);

    }

    //update

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id ,@RequestBody Event Updatedevent) {
        Event event = EventService.updateEvent(Updatedevent);
        return ResponseEntity.ok(event);
    }

    //getAll

    @GetMapping()
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event>  event = eventService.getAllEvents();
        return ResponseEntity.ok(event);
    }

    // getById

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable long id) {
        Event event = EventService.getEvent((int) id);

        return ResponseEntity.ok(event);
    }

    // deleteById

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable long id) {
        EventService.deleteEventById((int) id);
        return new ResponseEntity<>("Event deleted successfully.", HttpStatus.NO_CONTENT);
    }

    // deleteAll
//    @DeleteMapping()
//    public ResponseEntity<Event> deleteAllEvents() {
//        return null;
//    }

}
