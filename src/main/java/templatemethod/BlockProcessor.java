package templatemethod;

import singleton.Block;
import singleton.Blockchain;

public abstract class BlockProcessor {
    public final void processBlock(int index, String previousHash, String data) {
        validateBlock(data);
        Block newBlock = createBlock(index, previousHash, data);
        addBlockToChain(newBlock);
    }

    protected abstract String validateBlock(String data);

    private Block createBlock(int index, String previousHash, String data) {
        return new Block(index, previousHash, data);
    }

    private void addBlockToChain(Block block) {
        Blockchain.getInstance().addBlock(block);
    }
}
