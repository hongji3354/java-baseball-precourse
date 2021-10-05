package baseball.constant;

import java.util.HashMap;
import java.util.Map;

public enum GameRestart {

    YES("1"),
    NO("2");

    public String input;

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
            throw new IllegalArgumentException(String.format("%s는 지원되지 않는 값입니다.", input));
        }
        return findByRestart;
    }
}
