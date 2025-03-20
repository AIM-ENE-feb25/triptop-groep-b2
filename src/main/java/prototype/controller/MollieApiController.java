package prototype.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MollieApiController {

    @GetMapping("/create-transaction")
    public TransactionResponse createTransaction(
            @RequestParam String amount,
            @RequestParam String currency,
            @RequestParam String description) {
        // Create a transaction response (this is just a placeholder)
        TransactionResponse response = new TransactionResponse("tr_fakeTransactionId", amount, currency, description, "created");
        return response;
    }
}