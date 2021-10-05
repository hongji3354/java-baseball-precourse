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

    public boolean isAllStrike() {
        return this.strike == 3;
    }

    public boolean isStrike() {
        return this.strike != 0;
    }

    public boolean isBall() {
        return this.ball != 0;
    }

    public boolean isNotSing() {
        return !(isStrike() && isBall());
    }
}
