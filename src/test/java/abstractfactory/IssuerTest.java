package abstractfactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IssuerTest {
    @Test
    void shouldProcessPaymentTransactionAndStoreFunds(){
        BlockchainFactory blockchainFactory = new CryptoFactory();
        Issuer issuer = new Issuer(blockchainFactory);
        assertEquals("Processing Payment Transaction", issuer.processTransaction());
        assertEquals("Storing funds in Crypto Wallet", issuer.storeFundsWallet());
    }

    @Test
    void shouldProcessSmartContractTransactionAndStoreAssets(){
        BlockchainFactory blockchainFactory = new SmartContractFactory();
        Issuer issuer = new Issuer(blockchainFactory);
        assertEquals("Processing Smart Contract Transaction", issuer.processTransaction());
        assertEquals("Storing assets in Asset Wallet", issuer.storeFundsWallet());
    }
}
