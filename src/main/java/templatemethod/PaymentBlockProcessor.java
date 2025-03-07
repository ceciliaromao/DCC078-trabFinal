package templatemethod;

public class PaymentBlockProcessor extends BlockProcessor {
    @Override
    protected String validateBlock(String data) {
        return "Validating Payment Block: " + data;
    }
}
