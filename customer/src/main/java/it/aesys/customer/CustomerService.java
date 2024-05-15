package it.aesys.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    public final RestTemplate restTemplate;
    public final CustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder().
                firstname(request.firstName()).lastname(request.lastName()).email(request.email()).build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse customerObject = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",FraudCheckResponse.class,customer.getId());

        if(customerObject.isFraudolent()) {
            throw new IllegalStateException("fraudster");

        }

    }
}
