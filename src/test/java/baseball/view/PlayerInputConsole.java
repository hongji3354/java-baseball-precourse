package baseball.view;

import baseball.domain.Player;
import baseball.validator.PlayerInputValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nextstep.utils.Console;

public class PlayerInputConsole {

    private PlayerInputConsole() {
    }

    public static Player inputNumber() {
        final String inputNumber = Console.readLine();
        PlayerInputValidator.validator(inputNumber);
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
