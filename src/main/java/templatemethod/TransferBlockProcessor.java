package templatemethod;

public class TransferBlockProcessor extends BlockProcessor {
    @Override
    protected String validateBlock(String data) {
        return "Validating Transfer Block: " + data;
    }
}
