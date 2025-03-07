package templatemethod;

public class RedeemBlockProcessor extends BlockProcessor {
    @Override
    protected String validateBlock(String data) {
        return "Validating Redeem Block: " + data;
    }
}
