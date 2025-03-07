package abstractfactory;

public class PaymentTransaction implements Transaction{
    public String process() {
        return "Processing Payment Transaction";
    }
}
