package mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlockchainNetworkTest {
    private BlockchainMediator network;
    private User user;
    private Miner miner;
    private Validator validator;

    @BeforeEach
    void setUp() {
        network = new BlockchainNetwork();
        user = new User(network, new Node("User1", network));
        miner = new Miner(network, new Node("Miner1", network));
        validator = new Validator(network, new Node("Validator1", network));
    }

    @Test
    void shouldBroadcastMessageFromUser() {
        String message = "Transaction 100 BTC";
        String response = user.sendMessage(message);
        assertEquals("User User1 sending transaction: Transaction 100 BTC", response);
    }

    @Test
    void shouldBroadcastMessageFromMiner() {
        String response = miner.sendMessage("Block Mined");
        assertEquals("Miner Miner1 broadcasting: Block Mined", response);
    }

    @Test
    void shouldBroadcastMessageFromValidator() {
        String response = validator.sendMessage("Transaction Validated");
        assertEquals("Validator Validator1 broadcasting: Transaction Validated", response);
    }
}
