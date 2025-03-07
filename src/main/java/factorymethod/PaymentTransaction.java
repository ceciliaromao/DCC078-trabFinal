package factorymethod;

public class PaymentTransaction implements ITransaction{
    public String execute() {
        return "Executing Payment Transaction";
    }

    public String cancel() {
        return "Cancelling Payment Transaction";
    }
}
