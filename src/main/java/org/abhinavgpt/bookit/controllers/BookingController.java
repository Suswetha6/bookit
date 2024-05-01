package org.abhinavgpt.bookit.controllers;

import org.abhinavgpt.bookit.dtos.BookingDTO;
import org.abhinavgpt.bookit.exceptions.BookingNotFoundException;
import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.exceptions.EventNotFoundException;
import org.abhinavgpt.bookit.exceptions.NotEnoughTicketsException;
import org.abhinavgpt.bookit.modals.Booking;
import org.abhinavgpt.bookit.services.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/details/{bookingId}")
    public ResponseEntity<Booking> getBookingDetails(@PathVariable long bookingId) throws BookingNotFoundException {
        return ResponseEntity.ok(bookingService.getBookingDetails(bookingId));
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable long eventId) throws EventNotFoundException {
        return ResponseEntity.ok(bookingService.getAllBookings(eventId));
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable long bookingId) throws BookingNotFoundException, EventNotFoundException {
        return ResponseEntity.ok(bookingService.cancelBooking(bookingId));
    }

    @PutMapping("/update")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.updateBooking(booking));
    }

    @PostMapping("/book")
    public ResponseEntity<Booking> bookTicket(@RequestBody BookingDTO bookingDTO) throws CustomerNotFoundException, EventNotFoundException, NotEnoughTicketsException {
        return ResponseEntity.ok(bookingService.bookTicket(bookingDTO));

    }

    @GetMapping("/history/{customerId}")
    public ResponseEntity<List<Booking>> getBookingHistory(@PathVariable long customerId) throws BookingNotFoundException, CustomerNotFoundException {
        return ResponseEntity.ok(bookingService.getBookingHistory(customerId));
    }

}
