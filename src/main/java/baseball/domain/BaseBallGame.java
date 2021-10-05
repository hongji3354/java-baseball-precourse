package baseball.domain;

import baseball.view.PlayerInputConsole;
import baseball.view.PlayerOutputConsole;

public class BaseBallGame {

    private boolean isAllStrike = false;

    public void start() {
        final Computer computer = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();

        while (!this.isAllStrike) {
            Player players = getPlayer();
            final JudgmentResult judgments = Referee.judgment(computer, players);
            PlayerOutputConsole.judgmentResultPrint(judgments);
            gameEndCheck(judgments);
        }
    }

    private void gameEndCheck(JudgmentResult judgments) {
        if (judgments.isAllStrike()) {
            this.isAllStrike = true;
            PlayerOutputConsole.gameEndPrint();
            PlayerOutputConsole.reGamePrint();
        }
    }

    private static Player getPlayer() {
        try {
            return PlayerInputConsole.inputNumber();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayer();
        }
    }

    public boolean isGameEnd() {
        return isAllStrike;
    }

}
