package factorymethod;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MintTransactionTest {
    @Test
    void shouldExecuteMintTransaction() {
        ITransaction transaction = TransactionFactory.getTransaction("Mint");
        assertEquals("Executing Mint Transaction", transaction.execute());
    }

    @Test
    void shouldCancelMintTransaction() {
        ITransaction transaction = TransactionFactory.getTransaction("Mint");
        assertEquals("Cancelling Mint Transaction", transaction.cancel());
    }
}
