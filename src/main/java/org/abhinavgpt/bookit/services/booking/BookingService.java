package org.abhinavgpt.bookit.services.booking;

import org.abhinavgpt.bookit.dtos.BookingDTO;
import org.abhinavgpt.bookit.exceptions.BookingNotFoundException;
import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.exceptions.NotEnoughTicketsException;
import org.abhinavgpt.bookit.modals.Booking;

import java.util.List;

public interface BookingService {
    public Booking getBookingDetails(long id) throws BookingNotFoundException;

    public List<Booking> getBookingHistory(long customerId) throws BookingNotFoundException, CustomerNotFoundException;

    public Booking cancelBooking(long id) throws BookingNotFoundException, EventNotFoundException;

    public Booking bookTicket(BookingDTO bookingDTO) throws NotEnoughTicketsException, CustomerNotFoundException, EventNotFoundException;

    public Booking updateBooking(Booking booking);

    public List<Booking> getAllBookings(long eventId) throws EventNotFoundException;

}
