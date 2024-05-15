package it.aesys.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.event.InternalFrameAdapter;


public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory,Integer> {
       FraudCheckHistory findByCustomerId (Integer customerId);

}
