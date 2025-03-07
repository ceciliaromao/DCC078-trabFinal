package singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.google.gson.Gson;

public class BlockTest {
    @Test
    public void shouldReturnRightJson() {
        Block block = new Block(1, "hash_anterior", "Transação 1");
        Gson gson = new Gson();
        String jsonEsperado = gson.toJson(block);

        assertEquals(jsonEsperado, block.toJson());
    }
}
