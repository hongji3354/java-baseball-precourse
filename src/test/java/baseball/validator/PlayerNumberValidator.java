package baseball.validator;

import baseball.constant.GameNumberRule;
import baseball.constant.PlayerErrorMessage;
import java.util.HashSet;
import java.util.Set;

public class PlayerNumberValidator {

    private PlayerNumberValidator() {
    }

    public static void validator(String inputNumber) {
        numberThreeDigitCheck(inputNumber);
        for (int i=0; i<inputNumber.length(); i++) {
            final char number = inputNumber.charAt(i);
            numberCheck(number);
            numberRangeCheck(number);
        }
        numberDuplicateCheck(inputNumber);
    }

    private static void numberDuplicateCheck(String numericNumber) {
        Set<String> set = new HashSet<>();
        for (int i=0; i<numericNumber.length(); i++) {
            set.add(Character.toString(numericNumber.charAt(i)));
        }
        if (set.size() != GameNumberRule.DIGIT.getNumber()) {
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
