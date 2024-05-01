package org.abhinavgpt.bookit.modals;

import jakarta.persistence.*;
import org.abhinavgpt.bookit.modals.data.BookingStatus;

import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Event event;

    private int numberOfTickets;
    private BookingStatus bookingStatus;

    private LocalDateTime bookingTime;

    public Booking() {
    }

    public Booking(Customer customer, Event event, int numberOfTickets, BookingStatus bookingStatus, LocalDateTime bookingTime) {
        this.customer = customer;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
        this.bookingStatus = bookingStatus;
        this.bookingTime = bookingTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
