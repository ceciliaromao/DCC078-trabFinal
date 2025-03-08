package chainofresponsability;

import strategy.Transaction;

public class AmountValidationHandler extends TransactionHandler {
    public AmountValidationHandler(TransactionHandler next) {
        setNext(next);
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        return transaction.getAmount() > 0;
    }

    @Override
    public String getTransactionHandlerType() {
        return "Amount Validation Handler";
    }
}
