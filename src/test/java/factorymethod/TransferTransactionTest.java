package factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransferTransactionTest {
    @Test
    void shouldExecuteTransferTransaction() {
        ITransaction transaction = TransactionFactory.getTransaction("Transfer");
        assertEquals("Executing Transfer Transaction", transaction.execute());
    }

    @Test
    void shouldCancelTransferTransaction() {
        ITransaction transaction = TransactionFactory.getTransaction("Transfer");
        assertEquals("Cancelling Transfer Transaction", transaction.cancel());
    }
}
