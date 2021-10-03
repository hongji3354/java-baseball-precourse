package baseball.constant;

public enum GameNumberRule {

    START_INCLUSIVE(1),
    END_INCLUSIVE(9),
    DIGIT(3);

    private int number;

    GameNumberRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
