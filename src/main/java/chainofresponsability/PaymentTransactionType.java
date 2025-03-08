package chainofresponsability;

public class PaymentTransactionType implements TransactionType {
    private static final PaymentTransactionType paymentTransactionType = new PaymentTransactionType();
    private PaymentTransactionType() {};

    public static PaymentTransactionType getInstance() {
        return paymentTransactionType;
    }
}
