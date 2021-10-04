package baseball.domain;

import baseball.constant.GameNumberRule;
import java.util.List;

public class Referee {

    public static JudgmentResult judgment(Computer computer, Player player) {
        final JudgmentResult judgmentResult = new JudgmentResult();
        final List<Integer> computerPickNumbers = computer.getPickNumber();
        final List<Integer> playerPickNumbers = player.getPickNumber();

        for (int i=0; i<GameNumberRule.DIGIT.getNumber(); i++) {
            final Integer computerPickNumber = computerPickNumbers.get(i);
            final Integer playerPickNumber = playerPickNumbers.get(i);

            isStrike(judgmentResult, computerPickNumber, playerPickNumber);
            isBall(judgmentResult, playerPickNumbers, i, computerPickNumber);
        }
        return judgmentResult;
    }

    private static void isBall(JudgmentResult judgmentResult, List<Integer> playerPickNumbers,
        int i, Integer computerPickNumber) {
        if (playerPickNumbers.contains(computerPickNumber) && playerPickNumbers.indexOf(
            computerPickNumber) != i) {
            judgmentResult.addBall();
        }
    }

    private static void isStrike(JudgmentResult judgmentResult, Integer computerPickNumber,
        Integer playerPickNumber) {
        if (computerPickNumber.equals(playerPickNumber)) {
            judgmentResult.addStrike();
        }
    }
}
