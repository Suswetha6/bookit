package org.abhinavgpt.bookit.services.customer;

import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.modals.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(long customerId) throws CustomerNotFoundException;

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(long customerId);

    List<Customer> getAllCustomers();
}
