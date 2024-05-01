package org.abhinavgpt.bookit.controllers;

import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.modals.Customer;
import org.abhinavgpt.bookit.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Long customerId) throws CustomerNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") Long customerId, @RequestBody Customer updatedCustomer) {
        Customer customer = customerService.updateCustomer(updatedCustomer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Long customerId) {
            customerService.deleteCustomer(customerId);
            return ResponseEntity.ok("Customer deleted successfully");
    }
}
