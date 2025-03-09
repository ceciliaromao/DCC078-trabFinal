package mediator;

public class Miner extends Participant {
    public Miner(BlockchainMediator mediator, Node node) {
        super(mediator, node);
    }

    @Override
    public String sendMessage(String message) {
        mediator.broadcastMessage(message, this);
        return "Miner " + node.getAddress() + " broadcasting: " + message;
    }

    @Override
    public String receiveMessage(String message) {
        return "Miner " + node.getAddress() + " received: " + message;
    }
}
