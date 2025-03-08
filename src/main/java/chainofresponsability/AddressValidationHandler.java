package chainofresponsability;

import strategy.Transaction;

public class AddressValidationHandler extends TransactionHandler {
    public AddressValidationHandler(TransactionHandler next) {
        setNext(next);
    }

    @Override
    public boolean handleTransaction(Transaction transaction) {
        return transaction.getSender() != null && transaction.getReceiver() != null;
    }

    @Override
    public String getTransactionHandlerType() {
        return "Address Validation Handler";
    }
}
