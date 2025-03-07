package templatemethod;

public class SmartContractBlockProcessor extends BlockProcessor {
    @Override
    protected String validateBlock(String data) {
        return "Validating Smart Contract Block: " + data;
    }
}
