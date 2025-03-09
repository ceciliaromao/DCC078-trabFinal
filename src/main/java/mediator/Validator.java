package mediator;

public class Validator extends Participant {
    public Validator(BlockchainMediator mediator, Node node) {
        super(mediator, node);
    }

    @Override
    public String sendMessage(String message) {
        mediator.broadcastMessage(message, this);
        return "Validator " + node.getAddress() + " broadcasting: " + message;
    }

    @Override
    public String receiveMessage(String message) {
        return "Validator " + node.getAddress() + " received: " + message;
    }
}
