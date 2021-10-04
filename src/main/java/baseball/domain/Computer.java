package baseball.domain;

import java.util.List;

public class Computer {

    private List<Integer> pickNumber;

    public Computer(List<Integer> pickNumber) {
        this.pickNumber = pickNumber;
    }

    public List<Integer> getPickNumber() {
        return pickNumber;
    }
}
