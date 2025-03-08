package chainofresponsability;

public class SmartContactTransactionType implements TransactionType {
    private static final SmartContactTransactionType smartContactTransactionType = new SmartContactTransactionType();
    private SmartContactTransactionType() {};

    public static SmartContactTransactionType getInstance() {
        return smartContactTransactionType;
    }
}
