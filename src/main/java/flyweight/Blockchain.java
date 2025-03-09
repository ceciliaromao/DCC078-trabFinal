package flyweight;

import java.util.*;

public class Blockchain {
    private final Map<String, Transaction> ledger = new LinkedHashMap<>(); // Mantém a ordem de inserção

    public void addTransaction(String sender, String receiver, double amount) {
        Transaction transaction = TransactionFactory.getTransaction(sender, receiver, amount);
        ledger.put(sender + "->" + receiver + ":" + amount + ":" + ledger.size(), transaction); // Chave única por ordem de inserção
    }

    public List<String> getTransactions() {
        List<String> transactions = new ArrayList<>();
        for (Transaction transaction : ledger.values()) {
            transactions.add(transaction.getTransactionDetails());
        }
        return transactions;
    }
}
