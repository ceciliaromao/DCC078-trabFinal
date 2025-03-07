package strategy;

import java.time.Instant;
import java.time.Duration;

public class TimeValidationStrategy implements TransactionValidationStrategy {
    private static final long MAX_TRANSACTION_AGE_SECONDS = 300; // 5 minutos

    @Override
    public boolean validate(Transaction transaction) {
        Instant now = Instant.now();
        Instant transactionTime = transaction.getTimestamp();

        long ageInSeconds = Duration.between(transactionTime, now).getSeconds();

        return ageInSeconds <= MAX_TRANSACTION_AGE_SECONDS;
    }
}
