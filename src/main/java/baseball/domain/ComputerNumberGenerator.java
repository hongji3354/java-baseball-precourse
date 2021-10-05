package baseball.domain;

import baseball.constant.GameNumberRule;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import nextstep.utils.Randoms;

public class ComputerNumberGenerator {

    private ComputerNumberGenerator() {
    }

    public static Computer createNonDuplicateThreeDigitNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() != GameNumberRule.DIGIT.getNumber()) {
            numbers.add(createNumber());
        }
        return new Computer(new ArrayList<>(numbers));
    }

    private static int createNumber() {
        return Randoms.pickNumberInRange(GameNumberRule.START_INCLUSIVE.getNumber(), GameNumberRule.END_INCLUSIVE.getNumber());
    }
}
