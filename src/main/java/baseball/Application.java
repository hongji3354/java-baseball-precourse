package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.PlayerReGame;

public class Application {
    public static void main(String[] args) {
        final BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();

        if (baseBallGame.isGameEnd()) {
            PlayerReGame.reGameWhether();
        }
    }
}
