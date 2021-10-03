package baseball.domain;

import baseball.constant.GameNumberRule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import nextstep.utils.Randoms;

public class ComputerNumberGenerator {

    private ComputerNumberGenerator() {
    }

    public static List<Integer> createNonDuplicateThreeDigitNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() != GameNumberRule.DIGIT.getNumber()) {
            numbers.add(createNumber());
        }
        return Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    private static int createNumber() {
        return Randoms.pickNumberInRange(GameNumberRule.START_INCLUSIVE.getNumber(), GameNumberRule.END_INCLUSIVE.getNumber());
    }
}
