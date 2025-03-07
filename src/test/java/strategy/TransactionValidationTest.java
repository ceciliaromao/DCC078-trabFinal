package strategy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionValidationTest {
    @Test
    void shouldValidateTransactionSuccessfully() {
        Transaction transaction = new Transaction("0xSender", "0xReceiver", 100.0);

        TransactionValidationStrategy strategy1 = new BasicValidationStrategy();
        assertTrue(strategy1.validate(transaction));

        TransactionValidationStrategy strategy2 = new BalanceValidationStrategy(200);
        assertTrue(strategy2.validate(transaction));

        TransactionValidationStrategy strategy3 = new TimeValidationStrategy();
        assertTrue(strategy3.validate(transaction));
    }

    @Test
    void shouldInvalidateTransactionWithNullSender() {
        Transaction transaction = new Transaction(null, "0xReceiver", 200.0);
        TransactionValidationStrategy strategy = new BasicValidationStrategy();

        assertFalse(strategy.validate(transaction));
    }

    @Test
    void shouldInvalidateTransactionWithNullReceiver() {
        Transaction transaction = new Transaction("0xSender", null, 200.0);
        TransactionValidationStrategy strategy = new BasicValidationStrategy();

        assertFalse(strategy.validate(transaction));
    }

    @Test
    void shouldInvalidateTransactionWithInvalidAmount() {
        Transaction transaction = new Transaction("0xSender", "0xReceiver", -10.0);
        TransactionValidationStrategy strategy = new BasicValidationStrategy();

        assertFalse(strategy.validate(transaction));
    }


    @Test
    void shouldInvalidateTransactionWithNotEnoughBalance() {
        Transaction transaction = new Transaction("0xSender", "0xReceiver", 200.0);
        TransactionValidationStrategy strategy = new BalanceValidationStrategy(100.0);

        assertFalse(strategy.validate(transaction));
    }

    @Test
    void shouldInvalidateTooOldTransaction() throws NoSuchFieldException, IllegalAccessException {
        Transaction transaction = new Transaction("0xSender", "0xReceiver", 100.0);

        Field timestampField = Transaction.class.getDeclaredField("timestamp");
        timestampField.setAccessible(true);
        timestampField.set(transaction, Instant.now().minusSeconds(600));

        TransactionValidationStrategy strategy = new TimeValidationStrategy();
        assertFalse(strategy.validate(transaction));
    }

}
