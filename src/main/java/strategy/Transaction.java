package strategy;

import java.time.Instant;

public class Transaction {
    private final String sender;
    private final String receiver;
    private final double amount;
    private Instant timestamp;

    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = Instant.now();
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
