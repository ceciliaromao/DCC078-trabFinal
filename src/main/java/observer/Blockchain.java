package observer;

import java.util.Observable;

public class Blockchain extends Observable {

    public void addTransaction(String transaction) {
        setChanged();
        notifyObservers(transaction);
    }
}
