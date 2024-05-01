package org.abhinavgpt.bookit.services.booking.mapper;

import org.abhinavgpt.bookit.dtos.BookingDTO;
import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.modals.Booking;
import org.abhinavgpt.bookit.modals.Customer;
import org.abhinavgpt.bookit.modals.Event;
import org.abhinavgpt.bookit.modals.data.BookingStatus;
import org.abhinavgpt.bookit.services.customer.CustomerService;
import org.abhinavgpt.bookit.services.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DTOToBookingImpl implements  DTOToBooking{

    CustomerService customerService;
    EventService eventService;

    @Autowired
    public DTOToBookingImpl(CustomerService customerService, EventService eventService) {
        this.customerService = customerService;
        this.eventService = eventService;
    }

    @Override
    public Booking bookTicket(BookingDTO bookingDTO) throws CustomerNotFoundException, EventNotFoundException {
        Customer customer = customerService.getCustomerById(bookingDTO.customerId());
        Event event = eventService.getEvent(bookingDTO.eventId());
        LocalDateTime bookingTime = LocalDateTime.now();
         return new Booking(customer, event, bookingDTO.numberOfSeats(), BookingStatus.PENDING, bookingTime);
    }
}
