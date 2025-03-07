package singleton;

import com.google.gson.Gson;

public class Block {
    private int index;
    private String previousHash;
    private String data;

    public Block(int index, String previousHash, String data) {
        this.index = index;
        this.previousHash = previousHash;
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}