package templatemethod;

import singleton.Block;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferBlockProcessorTest {
    @Test
    void shouldReturnTransferBlockValidation() {
        TransferBlockProcessor processor = new TransferBlockProcessor();
        Block block = new Block(1, "hash_anterior", "Transação 1");
        assertEquals("Validating Transfer Block: Transação 1", processor.validateBlock(block.getData()));
    }
}
