package org.abhinavgpt.bookit.services.booking.mapper;

import org.abhinavgpt.bookit.dtos.BookingDTO;
import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.modals.Booking;

public interface DTOToBooking {
    Booking bookTicket(BookingDTO bookingDTO) throws CustomerNotFoundException, EventNotFoundException;
}
