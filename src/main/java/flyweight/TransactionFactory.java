package flyweight;

import java.util.HashMap;
import java.util.Map;

public class TransactionFactory {
    private static final Map<String, Transaction> transactions = new HashMap<>();

    public static Transaction getTransaction(String sender, String receiver, double amount) {
        String key = sender + "->" + receiver + ":" + amount;
        transactions.putIfAbsent(key, new Transaction(sender, receiver, amount));
        return transactions.get(key);
    }

    public static int getTotalTransactions() {
        return transactions.size();
    }
}
