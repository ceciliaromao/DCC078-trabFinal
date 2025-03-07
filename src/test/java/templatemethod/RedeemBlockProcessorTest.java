package templatemethod;

import singleton.Block;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedeemBlockProcessorTest {
    @Test
    void shouldReturnRedeemBlockValidation() {
        RedeemBlockProcessor processor = new RedeemBlockProcessor();
        Block block = new Block(1, "hash_anterior", "Transação 1");
        assertEquals("Validating Redeem Block: Transação 1", processor.validateBlock(block.getData()));
    }
}
