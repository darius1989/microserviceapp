package it.aesys.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster (@PathVariable("customerId") Integer customerId)
    {
        //log.info("new Customer registration {}", request);
        Boolean isFraudolent = fraudCheckService.isFraudolentCustomer(customerId);

        return new FraudCheckResponse(isFraudolent);

    }

    @PostMapping
    public FraudCheckHistory save (@RequestBody FraudCheckHistory fraudCheckHistory)
    {
        //log.info("new Customer registration {}", request);
       return  fraudCheckService.save(fraudCheckHistory);



    }
}
