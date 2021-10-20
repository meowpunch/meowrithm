package deliveryhero;

import java.util.List;
import java.util.stream.Collectors;


class Participant {
    private final String name;
    private final Integer score;

    Participant(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}

public class TopKParticipants {
    // With bucket sort, we could improve algorithm.
    public List<String> topKParticipants(List<Participant> participants, int k) {
        return participants.stream()
                .sorted((l, r) -> r.getScore() - l.getScore())
                .limit(k)
                .map(Participant::getName)
                .collect(Collectors.toList());
    }
}
