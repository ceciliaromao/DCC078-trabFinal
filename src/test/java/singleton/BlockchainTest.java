package singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class BlockchainTest {
    @Test
    public void shouldReturnSameInstance() {
        Blockchain blockchain1 = Blockchain.getInstance();
        Blockchain blockchain2 = Blockchain.getInstance();
        assertSame(blockchain1, blockchain2);
    }

    @Test
    public void shouldHaveGenesisBlock() {
        Blockchain blockchain = Blockchain.getInstance();
        List<Block> chain = blockchain.getChain();
        assertFalse(chain.isEmpty());
        assertEquals(0, chain.get(0).getIndex());
        assertEquals("0", chain.get(0).getPreviousHash());
        assertEquals("Genesis Block", chain.get(0).getData());
    }

    @Test
    public void shouldAddNewBlock() {
        Blockchain blockchain = Blockchain.getInstance();
        int initialSize = blockchain.getChain().size();
        blockchain.addBlock(new Block(1, "hash_genesis", "Transaction 1"));
        List<Block> chain = blockchain.getChain();
        assertEquals(initialSize + 1, blockchain.getChain().size());
        assertEquals(1, chain.get(1).getIndex());
        assertEquals("hash_genesis", chain.get(1).getPreviousHash());
        assertEquals("Transaction 1", chain.get(1).getData());
    }
}
