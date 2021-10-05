package baseball.domain;

import baseball.view.PlayerReGameInputConsole;

public class PlayerReGame {

    private PlayerReGame() {
    }

    public static void reGameWhether() {
        try {
            gameStart(PlayerReGameInputConsole.reGame());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            reGameWhether();
        }
    }

    private static void gameStart(boolean reGame) {
        if (reGame) {
            new BaseBallGame().start();
        }
    }
}
