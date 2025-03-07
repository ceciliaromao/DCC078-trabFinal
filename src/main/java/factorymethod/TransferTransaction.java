package factorymethod;

public class TransferTransaction implements ITransaction {
    public String execute() {
        return "Executing Transfer Transaction";
    }

    public String cancel() {
        return "Cancelling Transfer Transaction";
    }
}
