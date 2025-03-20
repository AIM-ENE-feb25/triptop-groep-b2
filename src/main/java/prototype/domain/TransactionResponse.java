package prototype.domain;

public class TransactionResponse {
    private String id;
    private String amount;
    private String currency;
    private String description;
    private String status;

    public TransactionResponse(String id, String amount, String currency, String description, String status) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.status = status;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}