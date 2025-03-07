package factorymethod;

public class RedeemTransaction implements ITransaction {
    public String execute() {
        return "Executing Redeem Transaction";
    }

    public String cancel() {
        return "Cancelling Redeem Transaction";
    }
}
