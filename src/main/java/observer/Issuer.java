package observer;

import java.util.Observable;
import java.util.Observer;

public class Issuer implements Observer {
    private final String address;
    private String latestTransaction;

    public Issuer(String address) {
        this.address = address;
    }

    public String getLatestTransaction() {
        return this.latestTransaction;
    }

    public String getAddress() {
        return address.substring(0, 6) + "..." + address.substring(address.length() - 4);
    }

    public void subscribe(Blockchain blockchain) {
        blockchain.addObserver(this);
    }

    @Override
    public void update(Observable blockchain, Object transaction) {
        this.latestTransaction = getAddress() + " received notification: New transaction - " + transaction.toString();
    }
}
