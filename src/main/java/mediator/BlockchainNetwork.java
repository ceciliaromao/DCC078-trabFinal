package mediator;

import java.util.ArrayList;
import java.util.List;

public class BlockchainNetwork implements BlockchainMediator {
    public List<Participant> participants = new ArrayList<>();

    @Override
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    @Override
    public String broadcastMessage(String message, Participant sender) {
        for (Participant participant : participants) {
            if (participant != sender) {
                return participant.receiveMessage(message);
            }
        }
        return null;
    }
}
