package mediator;

public abstract class Participant {
    protected BlockchainMediator mediator;
    protected Node node;

    public Participant(BlockchainMediator mediator, Node node) {
        this.mediator = mediator;
        this.node = node;
        mediator.addParticipant(this);
    }

    public abstract String sendMessage(String message);
    public abstract String receiveMessage(String message);
}
