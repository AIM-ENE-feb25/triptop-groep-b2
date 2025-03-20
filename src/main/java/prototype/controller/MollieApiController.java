package prototype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prototype.domain.TransactionResponse;
import prototype.service.MollieApiService;

import java.util.Map;

@RestController
public class MollieApiController {

    private final MollieApiService mollieApiService;

    @Autowired
    public MollieApiController(MollieApiService mollieApiService) {
        this.mollieApiService = mollieApiService;
    }

    @GetMapping("/create-transaction")
    public TransactionResponse createTransaction(
            @RequestParam String amount,
            @RequestParam String currency,
            @RequestParam String description) {
        Map<String, Object> transaction = mollieApiService.createTransaction(amount, currency, description);
        return new TransactionResponse(
                (String) transaction.get("id"),
                (String) transaction.get("amount"),
                (String) transaction.get("currency"),
                (String) transaction.get("description"),
                (String) transaction.get("status")
        );
    }
}