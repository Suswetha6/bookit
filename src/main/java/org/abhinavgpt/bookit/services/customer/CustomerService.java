package org.abhinavgpt.bookit.services.customer;

import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.modals.Customer;

public interface CustomerService {
    Customer getCustomerById(long customerId) throws CustomerNotFoundException;
}
