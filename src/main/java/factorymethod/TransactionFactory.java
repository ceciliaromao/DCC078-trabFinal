package factorymethod;

public class TransactionFactory {
    public static ITransaction getTransaction(String transaction) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("factorymethod."+transaction+"Transaction");
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Transaction not found");
        }
        if (!(objeto instanceof ITransaction)) {
            throw new IllegalArgumentException("Invalid Transaction");
        }
        return (ITransaction) objeto;
    }
}
