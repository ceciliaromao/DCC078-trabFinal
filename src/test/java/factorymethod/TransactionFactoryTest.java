package factorymethod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.discovery.predicates.IsTestFactoryMethod;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionFactoryTest {
    @Test
    void shouldReturnExceptionForTransactionNotFound() {
        try {
            ITransaction transaction = TransactionFactory.getTransaction("BuyToken");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Transaction not found", e.getMessage());
        }
    }

    @Test
    void shouldReturnExceptionForInvalidTransaction() {
        try {
            ITransaction transaction = TransactionFactory.getTransaction("SmartContract");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Transaction", e.getMessage());
        }
    }
}
