package baseball.validator;

import baseball.constant.GameRestart;
import baseball.constant.PlayerErrorMessage;

public class PlayerBaseBallReGameInputValidator {

    private PlayerBaseBallReGameInputValidator() {
    }

    public static void validator(String input) {
        if (!(GameRestart.YES.getInput().equals(input) || GameRestart.NO.getInput().equals(input))) {
            throw new IllegalArgumentException(PlayerErrorMessage.RE_GAME_INPUT_ERROR.getErrorMessage());
        }
    }

}
