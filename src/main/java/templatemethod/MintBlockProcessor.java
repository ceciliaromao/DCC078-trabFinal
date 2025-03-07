package templatemethod;

public class MintBlockProcessor extends BlockProcessor {
    @Override
    protected String validateBlock(String data) {
        return "Validating Mint Block: " + data;
    }
}
