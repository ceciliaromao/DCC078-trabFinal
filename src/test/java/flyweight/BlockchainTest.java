package flyweight;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BlockchainTest {
    @Test
    void shouldReturnTransactions() {
        Blockchain blockchain = new Blockchain();
        blockchain.addTransaction("Alice", "Bob", 10.0);
        blockchain.addTransaction("Charlie", "Bob", 15.0);
        blockchain.addTransaction("Alice", "Bob", 10.0);
        blockchain.addTransaction("Charlie", "David", 20.0);

        List<String> expectedTransactions = Arrays.asList(
                "Transaction{from='Alice', to='Bob', amount=10.0}",
                "Transaction{from='Charlie', to='Bob', amount=15.0}",
                "Transaction{from='Alice', to='Bob', amount=10.0}",
                "Transaction{from='Charlie', to='David', amount=20.0}"
        );

        assertEquals(expectedTransactions, blockchain.getTransactions());
    }

    @Test
    void shouldReturnTotalUniqueTransactions() {
        Blockchain blockchain = new Blockchain();
        blockchain.addTransaction("Alice", "Bob", 10.0);
        blockchain.addTransaction("Charlie", "Bob", 15.0);
        blockchain.addTransaction("Alice", "Bob", 10.0);
        blockchain.addTransaction("Charlie", "David", 20.0);

        assertEquals(3, TransactionFactory.getTotalTransactions());
    }
}
