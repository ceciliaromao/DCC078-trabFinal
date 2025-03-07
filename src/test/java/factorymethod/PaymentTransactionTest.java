package factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTransactionTest {
    @Test
    void shouldExecutePaymentTransaction() {
        ITransaction transaction = TransactionFactory.getTransaction("Payment");
        assertEquals("Executing Payment Transaction", transaction.execute());
    }

    @Test
    void shouldCancelPaymentTransaction() {
        ITransaction transaction = TransactionFactory.getTransaction("Payment");
        assertEquals("Cancelling Payment Transaction", transaction.cancel());
    }
}
