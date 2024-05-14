package it.aesys.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().
                firstname(request.firstName()).lastname(request.lastName()).email(request.email()).build();
    }
}
