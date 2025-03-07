package abstractfactory;

public class CryptoFactory implements BlockchainFactory {
    public Transaction createTransaction() {
        return new PaymentTransaction();
    }

    public Wallet createWallet() {
        return new CryptoWallet();
    }
}