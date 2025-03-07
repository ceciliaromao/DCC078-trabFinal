package strategy;

public class BalanceValidationStrategy implements TransactionValidationStrategy {
    private final double senderBalance;

    public BalanceValidationStrategy(double senderBalance) {
        this.senderBalance = senderBalance;
    }

    @Override
    public boolean validate(Transaction transaction) {
        return senderBalance >= transaction.getAmount();
    }
}
