package strategy;

public interface TransactionValidationStrategy {
    boolean validate(Transaction transaction);
}
