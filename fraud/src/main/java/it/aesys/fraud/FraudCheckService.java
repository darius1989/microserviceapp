package it.aesys.fraud;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private FraudCheckHistoryRepository fraudRepository;


    public boolean isFraudolentCustomer(Integer id) {
        fraudRepository.save(FraudCheckHistory.builder().
                customerId(id).isFraudolent(false).
                createdAt(LocalDateTime.now())
                .build());
        return false;
    }


}
