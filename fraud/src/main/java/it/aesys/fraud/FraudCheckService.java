package it.aesys.fraud;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private FraudCheckHistoryRepository fraudRepository;


    public Boolean isFraudolentCustomer(Integer customerId) {

        FraudCheckHistory fraudCheckHistory = fraudRepository.findByCustomerId(customerId);

        return fraudCheckHistory.getIsFraudolent();
    }

    public FraudCheckHistory save(FraudCheckHistory fraudCheckHistory) {

        return fraudRepository.save(fraudCheckHistory);
    }


}
