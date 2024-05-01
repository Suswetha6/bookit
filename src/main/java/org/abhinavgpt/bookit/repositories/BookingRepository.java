package org.abhinavgpt.bookit.repositories;

import org.abhinavgpt.bookit.modals.Booking;
import org.abhinavgpt.bookit.modals.Customer;
import org.abhinavgpt.bookit.modals.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByCustomer(Customer customer);
    List<Booking> findAllByEvent(Event event);
}
