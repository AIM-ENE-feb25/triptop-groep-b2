package oude_Prototype.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MollieApiService {

    public Map<String, Object> createTransaction(String amount, String currency, String description) {
        // Simulate a transaction response
        Map<String, Object> transaction = new HashMap<>();
        transaction.put("id", "tr_fakeTransactionId");
        transaction.put("amount", amount);
        transaction.put("currency", currency);
        transaction.put("description", description);
        transaction.put("status", "created");
        return transaction;
    }
}