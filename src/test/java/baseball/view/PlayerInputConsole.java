package baseball.view;

import baseball.constant.GameRestart;
import baseball.domain.Player;
import baseball.validator.PlayerBaseBallGameInputValidator;
import baseball.validator.PlayerBaseBallReGameInputValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nextstep.utils.Console;

public class PlayerInputConsole {

    private PlayerInputConsole() {
    }

    public static Player inputNumber() {
        System.out.print("숫자를 입력해주세요 :");
        final String inputNumber = Console.readLine();
        PlayerBaseBallGameInputValidator.validator(inputNumber);
        return new Player(Collections.unmodifiableList(stringToIntegerList(inputNumber)));
    }

    private static List<Integer> stringToIntegerList(String inputNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<inputNumber.length(); i++) {
            numbers.add(Character.getNumericValue(inputNumber.charAt(i)));
        }
        return numbers;
    }
}
