package mediator;

public class User extends Participant {
    public User(BlockchainMediator mediator, Node node) {
        super(mediator, node);
    }

    @Override
    public String sendMessage(String message) {
        mediator.broadcastMessage(message, this);
        return "User " + node.getAddress() + " sending transaction: " + message;
    }

    @Override
    public String receiveMessage(String message) {
        return "User " + node.getAddress() + " received: " + message;
    }
}
