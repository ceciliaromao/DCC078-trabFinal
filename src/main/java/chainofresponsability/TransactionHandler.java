package chainofresponsability;

import strategy.Transaction;

public abstract class TransactionHandler {
    private TransactionHandler next;

    public TransactionHandler getNext() {
        return next;
    }

    public void setNext(TransactionHandler next) {
        this.next = next;
    }

    public String signTransaction(Transaction transaction) {
        if (!handleTransaction(transaction)) {
            return getTransactionHandlerType() + " denied transaction!";
        }
        if (next != null) {
            return next.signTransaction(transaction);
        }
        return "Transaction Signed!";
    }

    public abstract boolean handleTransaction(Transaction transaction);
    public abstract String getTransactionHandlerType();
}
