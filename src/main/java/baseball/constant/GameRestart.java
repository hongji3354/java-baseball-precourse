package baseball.constant;

import java.util.HashMap;
import java.util.Map;

public enum GameRestart {

    YES("1"),
    NO("2");

    private String input;

    GameRestart(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    private static Map<String, GameRestart> restartMap = new HashMap<>();

    static {
        for (GameRestart value : GameRestart.values()) {
            restartMap.put(value.getInput(), value);
        }
    }

    public static GameRestart of(String input) {
        GameRestart findByRestart = restartMap.get(input);
        if (findByRestart == null) {
            throw new IllegalArgumentException(PlayerErrorMessage.RE_GAME_INPUT_ERROR.getErrorMessage());
        }
        return findByRestart;
    }
}
