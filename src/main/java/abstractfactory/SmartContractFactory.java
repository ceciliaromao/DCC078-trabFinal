package abstractfactory;

public class SmartContractFactory implements BlockchainFactory {
    public Transaction createTransaction() {
        return new SmartContractTransaction();
    }

    public Wallet createWallet() {
        return new AssetWallet();
    }
}
