package org.abhinavgpt.bookit;

import org.abhinavgpt.bookit.controllers.CustomerController;
import org.abhinavgpt.bookit.exceptions.CustomerNotFoundException;
import org.abhinavgpt.bookit.modals.Customer;
import org.abhinavgpt.bookit.services.customer.CustomerService;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.Mockito.when;


@SpringBootTest
class BookitApplicationTests {

}
