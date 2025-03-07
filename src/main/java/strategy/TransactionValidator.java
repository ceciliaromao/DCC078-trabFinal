package strategy;

public class TransactionValidator {
    private TransactionValidationStrategy strategy;

    public TransactionValidator(TransactionValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TransactionValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(Transaction transaction) {
        return strategy.validate(transaction);
    }
}
