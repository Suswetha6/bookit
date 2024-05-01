package org.abhinavgpt.bookit.services.booking;

import org.abhinavgpt.bookit.dtos.BookingDTO;
import org.abhinavgpt.bookit.exceptions.BookingNotFoundException;
import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.exceptions.NotEnoughTicketsException;
import org.abhinavgpt.bookit.modals.Booking;
import org.abhinavgpt.bookit.modals.Customer;
import org.abhinavgpt.bookit.modals.Event;
import org.abhinavgpt.bookit.repositories.BookingRepository;
import org.abhinavgpt.bookit.services.booking.mapper.DTOToBooking;
import org.abhinavgpt.bookit.services.customer.CustomerService;
import org.abhinavgpt.bookit.services.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    CustomerService customerService;
    EventService eventService;
    DTOToBooking dtoToBooking;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, CustomerService customerService, EventService eventService, DTOToBooking dtoToBooking) {
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
        this.eventService = eventService;
        this.dtoToBooking = dtoToBooking;
    }

    @Override
    public Booking getBookingDetails(long id) throws BookingNotFoundException {
        return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not found"));
    }

    @Override
    public List<Booking> getBookingHistory(long customerId) throws BookingNotFoundException, CustomerNotFoundException {
        Customer customer;

        customer = customerService.getCustomerById(customerId);

        try {
            return bookingRepository.findAllByCustomer(customer);
        } catch (Exception e) {
            throw new BookingNotFoundException("Booking not found");
        }
    }

    @Override
    public Booking cancelBooking(long id) throws BookingNotFoundException, EventNotFoundException {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not found"));
        bookingRepository.delete(booking);
        Event event = eventService.getEvent(booking.getEvent().getId());
        event.setRemainingTickets(event.getRemainingTickets() + booking.getNumberOfTickets());
        eventService.updateEvent(event);
        return booking;
    }

    @Override
    public Booking bookTicket(BookingDTO bookingDTO) throws NotEnoughTicketsException, CustomerNotFoundException, EventNotFoundException {
        Event event = eventService.getEvent(bookingDTO.eventId());
        if (event.getRemainingTickets() < bookingDTO.numberOfSeats()) {
            throw new NotEnoughTicketsException("Not enough tickets available");
        }
        Booking booking = dtoToBooking.bookTicket(bookingDTO);
        bookingRepository.save(booking);
        event.setRemainingTickets(event.getRemainingTickets() - bookingDTO.numberOfSeats());
        eventService.updateEvent(event);
        return booking;
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings(long eventId) throws EventNotFoundException {
        Event event = eventService.getEvent(eventId);
        return bookingRepository.findAllByEvent(event);
    }
}
