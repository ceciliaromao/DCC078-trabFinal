package abstractfactory;

public class Issuer {
    private Transaction transaction;
    private Wallet wallet;

    public Issuer(BlockchainFactory blockchainFactory) {
        this.transaction = blockchainFactory.createTransaction();
        this.wallet = blockchainFactory.createWallet();
    }

    public String processTransaction() {
        return this.transaction.process();
    }

    public String storeFundsWallet() {
        return this.wallet.storeFunds();
    }
}
