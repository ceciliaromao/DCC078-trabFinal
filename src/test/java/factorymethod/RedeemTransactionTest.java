package factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RedeemTransactionTest {
    @Test
    void shouldExecuteRedeemTransaction() {
        ITransaction transaction = TransactionFactory.getTransaction("Redeem");
        assertEquals("Executing Redeem Transaction", transaction.execute());
    }

    @Test
    void shouldCancelRedeemTransaction() {
        ITransaction transaction = TransactionFactory.getTransaction("Redeem");
        assertEquals("Cancelling Redeem Transaction", transaction.cancel());
    }
}
