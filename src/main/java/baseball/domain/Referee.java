package baseball.domain;

import baseball.constant.GameNumberRule;
import java.util.List;

public class Referee {

    private Referee() {
    }

    public static JudgmentResult judgment(Computer computer, Player player) {
        final JudgmentResult judgmentResult = new JudgmentResult();
        final List<Integer> computerPickNumbers = computer.getPickNumber();
        final List<Integer> playerPickNumbers = player.getPickNumber();

        for (int i=0; i<GameNumberRule.DIGIT.getNumber(); i++) {
            strikeCheck(judgmentResult, computerPickNumbers.get(i), playerPickNumbers.get(i));
            ballCheck(judgmentResult, playerPickNumbers, i, computerPickNumbers.get(i));
        }
        return judgmentResult;
    }

    private static void ballCheck(JudgmentResult judgmentResult, List<Integer> playerPickNumbers,
        int i, Integer computerPickNumber) {
        if (playerPickNumbers.contains(computerPickNumber) && anotherLocation(playerPickNumbers, i,
            computerPickNumber)) {
            judgmentResult.addBall();
        }
    }

    private static boolean anotherLocation(List<Integer> playerPickNumbers, int i,
        Integer computerPickNumber) {
        return playerPickNumbers.indexOf(
            computerPickNumber) != i;
    }

    private static void strikeCheck(JudgmentResult judgmentResult, Integer computerPickNumber,
        Integer playerPickNumber) {
        if (computerPickNumber.equals(playerPickNumber)) {
            judgmentResult.addStrike();
        }
    }
}
