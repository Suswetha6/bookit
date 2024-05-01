package org.abhinavgpt.bookit.controllers;

import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.modals.Customer;
import org.abhinavgpt.bookit.services.customer.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class CustomerControllerTest {

    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

    @Test
    void createCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setId(1L);
        newCustomer.setName("John Doe");

        when(customerService.addCustomer(newCustomer)).thenReturn(newCustomer);

        ResponseEntity<Customer> response = customerController.createCustomer(newCustomer);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Customer returnedCustomer = response.getBody();
        assertEquals(newCustomer, returnedCustomer);
    }

    @Test
    void getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        when(customerService.getAllCustomers()).thenReturn(customers);

        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<Customer> returnedCustomers = response.getBody();
        assertEquals(customers, returnedCustomers);
    }

    @Test
    void getCustomerById() {
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setName("John Doe");
        try {
            when(customerService.getCustomerById(customerId)).thenReturn(customer);
            ResponseEntity<Customer> response = customerController.getCustomerById(customerId);
            assertEquals(HttpStatus.OK, response.getStatusCode());
            Customer returnedCustomer = response.getBody();
            assertEquals(customer, returnedCustomer);
        } catch (CustomerNotFoundException e) {
            fail("Customer not found exception occurred.");
        }
    }

    @Test
    void updateCustomer() {
        Long customerId = 1L;
        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(customerId);
        updatedCustomer.setName("Updated Name");
        when(customerService.updateCustomer(updatedCustomer)).thenReturn(updatedCustomer);

        ResponseEntity<Customer> response = customerController.updateCustomer(customerId, updatedCustomer);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        Customer returnedCustomer = response.getBody();
        assertEquals(updatedCustomer, returnedCustomer);
    }

    @Test
    void deleteCustomer() {
        long customerId = 1L;

        customerController.deleteCustomer(customerId);

        Mockito.verify(customerService, times(1)).deleteCustomer(customerId);
    }

}