package org.abhinavgpt.bookit.services.event;

import org.abhinavgpt.bookit.dtos.EventDTO;
import org.abhinavgpt.bookit.exceptions.CinemaHallNotFoundException;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.exceptions.InvalidTimeSelectionException;
import org.abhinavgpt.bookit.exceptions.MovieNotFoundException;
import org.abhinavgpt.bookit.modals.CinemaHall;
import org.abhinavgpt.bookit.modals.Event;
import org.abhinavgpt.bookit.modals.Movie;
import org.abhinavgpt.bookit.repositories.EventRepository;
import org.abhinavgpt.bookit.services.cinemahall.CinemaHallService;
import org.abhinavgpt.bookit.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final MovieService movieService;
    private final CinemaHallService hallService;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, MovieService movieService, CinemaHallService cinemaHallService) {
        this.eventRepository = eventRepository;
        this.movieService = movieService;
        this.hallService = cinemaHallService;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(long eventId) throws EventNotFoundException {
        return eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event with id: " + eventId + " not found!"));
    }

    @Override
    public Event addEvent(EventDTO event) throws MovieNotFoundException, CinemaHallNotFoundException, InvalidTimeSelectionException {
//        Need to check if no other event at that time exists in that particular hall
        Movie movie = movieService.getMovieById(event.movieId());
        CinemaHall cinemaHall =  hallService.getCinemaHallById(event.hallId());
        List<Event> events = eventRepository.findByStartTimeBetweenAndCinemaHall(LocalDateTime.parse(event.startTime()), LocalDateTime.parse(event.endTime()), cinemaHall);
        if(!events.isEmpty()) {
            throw new InvalidTimeSelectionException("Event already exists at that time in the hall");
        }

        Event newEvent = new Event(movie, cinemaHall, cinemaHall.getCapacity(), event.price(), LocalDateTime.parse(event.startTime()), LocalDateTime.parse(event.endTime()));
        return eventRepository.save(newEvent);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEventById(long eventId) {
        eventRepository.deleteById(eventId);
    }
}
