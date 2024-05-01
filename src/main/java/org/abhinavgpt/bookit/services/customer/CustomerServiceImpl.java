package org.abhinavgpt.bookit.services.customer;

import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.modals.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public Customer getCustomerById(long customerId) throws CustomerNotFoundException {
        return null;
    }
}
