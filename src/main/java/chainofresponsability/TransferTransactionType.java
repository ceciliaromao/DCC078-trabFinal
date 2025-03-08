package chainofresponsability;

public class TransferTransactionType implements TransactionType {
    private static final TransferTransactionType transferTransactionType = new TransferTransactionType();
    private TransferTransactionType() {};

    public static TransferTransactionType getInstance() {
        return transferTransactionType;
    }
}
