package templatemethod;

import singleton.Block;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartContractBlockProcessorTest {
    @Test
    void shouldReturnSmartContractBlockValidation() {
        SmartContractBlockProcessor processor = new SmartContractBlockProcessor();
        Block block = new Block(1, "hash_anterior", "Transação 1");
        assertEquals("Validating Smart Contract Block: Transação 1", processor.validateBlock(block.getData()));
    }
}
