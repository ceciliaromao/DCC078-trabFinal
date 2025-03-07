package abstractfactory;

public interface BlockchainFactory {
    Transaction createTransaction();
    Wallet createWallet();
}
