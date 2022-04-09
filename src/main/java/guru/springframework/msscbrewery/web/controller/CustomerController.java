package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable("customerId") UUID customerId) {
        return customerService.getCustomerById(customerId);
    }

}
