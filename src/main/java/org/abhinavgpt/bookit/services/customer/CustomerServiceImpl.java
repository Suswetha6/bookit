package org.abhinavgpt.bookit.services.customer;

import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.modals.Customer;
import org.abhinavgpt.bookit.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(long customerId) throws CustomerNotFoundException {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found."));
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
