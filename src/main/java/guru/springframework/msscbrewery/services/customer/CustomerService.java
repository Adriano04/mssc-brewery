package guru.springframework.msscbrewery.services.customer;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
    CustomerDto addCustomer(CustomerDto customerDto);
    void updateCustomer(UUID customerId, CustomerDto customerDto);
    void deleteCustomerById(UUID customerId);
}
