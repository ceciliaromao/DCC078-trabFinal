package templatemethod;

import singleton.Block;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MintBlockProcessorTest {
    @Test
    void shouldReturnMintBlockValidation() {
        MintBlockProcessor processor = new MintBlockProcessor();
        Block block = new Block(1, "hash_anterior", "Transação 1");
        assertEquals("Validating Mint Block: Transação 1", processor.validateBlock(block.getData()));
    }
}
