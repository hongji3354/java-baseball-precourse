package baseball.domain;

public class JudgmentResult {

    private int strike;
    private int ball;

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
