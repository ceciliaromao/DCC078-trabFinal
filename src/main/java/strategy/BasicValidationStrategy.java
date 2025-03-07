package strategy;

public class BasicValidationStrategy implements TransactionValidationStrategy {
    @Override
    public boolean validate(Transaction transaction) {
        return transaction.getSender() != null &&
                transaction.getReceiver() != null &&
                transaction.getAmount() > 0;
    }
}
