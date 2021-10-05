package baseball.view;

import baseball.constant.GameRestart;
import baseball.validator.PlayerBaseBallReGameInputValidator;
import nextstep.utils.Console;

public class PlayerReGameInputConsole {

    public static boolean reGame() {
        final String reGame = Console.readLine();
        PlayerBaseBallReGameInputValidator.validator(reGame);
        return GameRestart.YES == GameRestart.of(reGame);
    }

}
