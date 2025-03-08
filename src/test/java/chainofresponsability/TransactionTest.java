package chainofresponsability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.Transaction;

import java.lang.reflect.Field;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    TimeValidationHandler timeValidationHandler;
    AddressValidationHandler addressValidationHandler;
    AmountValidationHandler amountValidationHandler;

    Transaction transaction = new Transaction("0xSender", "0xReceiver", 100.0);
    Transaction nullSendertransaction = new Transaction(null, "0xReceiver", 100.0);
    Transaction nullReceiverTransaction = new Transaction("0xSender", null, 100.0);
    Transaction invalidAmountTransaction = new Transaction("0xSender", "0xReceiver", -100.0);

    @BeforeEach
    void setUp() {
        timeValidationHandler = new TimeValidationHandler(null);
        addressValidationHandler = new AddressValidationHandler(timeValidationHandler);
        amountValidationHandler = new AmountValidationHandler(addressValidationHandler);
    }

    @Test
    void shouldNotValidateTransactionByAmount() {
        assertEquals("Amount Validation Handler denied transaction!", amountValidationHandler.signTransaction(invalidAmountTransaction));
    }

    @Test
    void shouldNotValidateTransactionBySenderAddress() {
        assertEquals("Address Validation Handler denied transaction!", amountValidationHandler.signTransaction(nullSendertransaction));
    }

    @Test
    void shouldNotValidateTransactionByReceiverAddress() {
        assertEquals("Address Validation Handler denied transaction!", amountValidationHandler.signTransaction(nullReceiverTransaction));
    }

    @Test
    void shouldNotValidateTransactionByTime() throws NoSuchFieldException, IllegalAccessException {
        Field timestampField = Transaction.class.getDeclaredField("timestamp");
        timestampField.setAccessible(true);
        timestampField.set(transaction, Instant.now().minusSeconds(600));

        assertEquals("Time Validation Handler denied transaction!", amountValidationHandler.signTransaction(transaction));
    }

    @Test
    void shouldValidateTransaction() {
        assertEquals("Transaction Signed!", amountValidationHandler.signTransaction(transaction));
    }
}
