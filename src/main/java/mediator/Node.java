package mediator;

public class Node {
    private final String address;
    private final BlockchainMediator mediator;

    public Node(String address, BlockchainMediator mediator) {
        this.address = address;
        this.mediator = mediator;
    }

    public String getAddress() {
        return address;
    }
}
