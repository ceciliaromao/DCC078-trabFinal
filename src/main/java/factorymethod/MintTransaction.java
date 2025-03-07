package factorymethod;

public class MintTransaction implements ITransaction {
    public String execute() {
        return "Executing Mint Transaction";
    }

    public String cancel() {
        return "Cancelling Mint Transaction";
    }
}
