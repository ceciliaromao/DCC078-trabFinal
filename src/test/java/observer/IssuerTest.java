package observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IssuerTest {
    @Test
    void shouldNotifyAnIssuer() {
        Blockchain blockchain = new Blockchain();
        Issuer issuer = new Issuer("0xDA652D568Bf5dB3bEa8505B4211aC90c3199e97f");
        issuer.subscribe(blockchain);
        blockchain.addTransaction("Payment");
        assertEquals("0xDA65...e97f received notification: New transaction - Payment", issuer.getLatestTransaction());
    }

    @Test
    void shouldNotifyIssuers() {
        Blockchain blockchain = new Blockchain();
        Issuer issuer1 = new Issuer("0xDA652D568Bf5dB3bEa8505B4211aC90c3199e97f");
        Issuer issuer2 = new Issuer("0xBcf62100E4ca76c3Be55aA9e3bA6e56D57985A3F");
        issuer1.subscribe(blockchain);
        issuer2.subscribe(blockchain);
        blockchain.addTransaction("SmartContract");
        assertEquals("0xDA65...e97f received notification: New transaction - SmartContract", issuer1.getLatestTransaction());
        assertEquals("0xBcf6...5A3F received notification: New transaction - SmartContract", issuer2.getLatestTransaction());
    }

    @Test
    void shouldNotNotifyIssuer() {
        Blockchain blockchain = new Blockchain();
        Issuer issuer = new Issuer("0xDA652D568Bf5dB3bEa8505B4211aC90c3199e97f");
        blockchain.addTransaction("Payment");
        assertNull(issuer.getLatestTransaction());
    }

    @Test
    void shouldNotifyOnlyIssuerOnNetworkA() {
        Blockchain blockchainA = new Blockchain();
        Blockchain blockchainB = new Blockchain();
        Issuer issuer1 = new Issuer("0xDA652D568Bf5dB3bEa8505B4211aC90c3199e97f");
        Issuer issuer2 = new Issuer("0xBcf62100E4ca76c3Be55aA9e3bA6e56D57985A3F");

        issuer1.subscribe(blockchainA);
        issuer2.subscribe(blockchainB);

        blockchainA.addTransaction("Transfer");

        assertEquals("0xDA65...e97f received notification: New transaction - Transfer", issuer1.getLatestTransaction());
        assertNull(issuer2.getLatestTransaction());
    }
}
