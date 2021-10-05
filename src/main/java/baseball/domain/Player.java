package baseball.domain;

import java.util.Collections;
import java.util.List;

public class Player {

    private List<Integer> pickNumber;

    public Player(List<Integer> pickNumber) {
        this.pickNumber = pickNumber;
    }

    public List<Integer> getPickNumber() {
        return Collections.unmodifiableList(pickNumber);
    }
}
