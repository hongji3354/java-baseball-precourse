package baseball.view;

import baseball.constant.PlayerErrorMessage;
import baseball.constant.GameNumberRule;
import baseball.domain.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nextstep.utils.Console;

public class PlayerNumberInputConsole {

    public static Player inputNumber() {
        final String inputNumber = Console.readLine();
        numberThreeDigitCheck(inputNumber);
        List<Integer> numbers = new ArrayList<>();

        for (int i=0; i<inputNumber.length(); i++) {
            final char number = inputNumber.charAt(i);
            numberCheck(number);
            numberRangeCheck(number);

            final int numericNumber = Character.getNumericValue(number);
            numberDuplicateCheck(numbers, numericNumber);
            numbers.add(numericNumber);
        }
        return new Player(Collections.unmodifiableList(numbers));
    }

    private static void numberDuplicateCheck(List<Integer> numbers, int numericNumber) {
        if (numbers.contains(numericNumber)) {
            throw new IllegalArgumentException(PlayerErrorMessage.DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    private static void numberRangeCheck(char number) {
        if (minimumNumberUnder(number) || maximumNumberExcess(number)) {
            throw new IllegalArgumentException(PlayerErrorMessage.NUMBER_RANGE_OUT.getErrorMessage());
        }
    }

    private static boolean maximumNumberExcess(char number) {
        return Character.getNumericValue(
            number) > GameNumberRule.END_INCLUSIVE.getNumber();
    }

    private static boolean minimumNumberUnder(char number) {
        return Character.getNumericValue(number) < GameNumberRule.START_INCLUSIVE.getNumber();
    }

    private static void numberCheck(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException(PlayerErrorMessage.NOT_NUMBER.getErrorMessage());
        }
    }

    private static void numberThreeDigitCheck(String inputNumber) {
        if (inputNumber.length() != GameNumberRule.DIGIT.getNumber()) {
            throw new IllegalArgumentException(PlayerErrorMessage.DIGIT_RANGE_OUT.getErrorMessage());
        }
    }
}
