package templatemethod;

import singleton.Block;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentBlockProcessorTest {
    @Test
    void shouldReturnPaymentBlockValidation() {
        PaymentBlockProcessor processor = new PaymentBlockProcessor();
        Block block = new Block(1, "hash_anterior", "Transação 1");
        assertEquals("Validating Payment Block: Transação 1", processor.validateBlock(block.getData()));
    }
}
