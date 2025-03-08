package templatemethod;

import singleton.Blockchain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlockProcessorTest {
    Blockchain blockchain = Blockchain.getInstance();

    @Test
    public void shouldAddPaymentBlockToBlockchain() {
        int initialSize = blockchain.getChain().size();

        BlockProcessor processor = new PaymentBlockProcessor();
        processor.processBlock(1, "hash_genesis", "Payment Transaction");

        assertEquals(initialSize + 1, blockchain.getChain().size());
    }

    @Test
    public void shouldAddTransferBlockToBlockchain() {
        int initialSize = blockchain.getChain().size();

        BlockProcessor processor = new TransferBlockProcessor();
        processor.processBlock(2, "hash_previous", "Transfer Transaction");

        assertEquals(initialSize + 1, blockchain.getChain().size());
    }

    @Test
    public void shouldAddSmartContractBlockToBlockchain() {
        int initialSize = blockchain.getChain().size();

        BlockProcessor processor = new SmartContractBlockProcessor();
        processor.processBlock(3, "hash_previous", "Smart Contract Execution");

        assertEquals(initialSize + 1, blockchain.getChain().size());
    }
}
