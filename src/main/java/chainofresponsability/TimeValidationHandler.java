package chainofresponsability;

import strategy.Transaction;
import java.time.Instant;
import java.time.Duration;

public class TimeValidationHandler extends TransactionHandler {
    private static final long MAX_TRANSACTION_AGE_SECONDS = 300;

    public TimeValidationHandler(TransactionHandler next) {
        setNext(next);
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        Instant now = Instant.now();
        return Duration.between(transaction.getTimestamp(), now).getSeconds() <= MAX_TRANSACTION_AGE_SECONDS;
    }

    @Override
    public String getTransactionHandlerType() {
        return "Time Validation Handler";
    }
}
