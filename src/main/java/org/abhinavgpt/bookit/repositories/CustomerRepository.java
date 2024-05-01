package org.abhinavgpt.bookit.repositories;


import org.abhinavgpt.bookit.modals.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
