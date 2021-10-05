package baseball.domain;

import baseball.view.PlayerReGameInputConsole;

public class PlayerReGame {

    private PlayerReGame() {
    }

    public static void reGameWhether() {
        if (PlayerReGameInputConsole.reGame()) {
            new BaseBallGame().start();
        }
    }

}
