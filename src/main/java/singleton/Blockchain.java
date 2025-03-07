package singleton;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private static Blockchain instance;
    private List<Block> chain;

    private Blockchain() {
        this.chain = new ArrayList<>();
        this.chain.add(createGenesisBlock());
    }

    public static Blockchain getInstance() {
        if (instance == null) {
            instance = new Blockchain();
        }
        return instance;
    }

    private Block createGenesisBlock() {
        return new Block(0, "0", "Genesis Block");
    }

    public void addBlock(Block newBlock) {
        chain.add(newBlock);
    }

    public List<Block> getChain() {
        return chain;
    }
}
