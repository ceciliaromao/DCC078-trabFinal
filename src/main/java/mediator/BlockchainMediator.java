package mediator;

public interface BlockchainMediator {
    void addParticipant(Participant participant);
    String broadcastMessage(String message, Participant sender);
}
