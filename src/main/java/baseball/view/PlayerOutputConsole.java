package baseball.view;

import baseball.domain.JudgmentResult;

public class PlayerOutputConsole {

    private PlayerOutputConsole() {
    }

    // TODO : 10라인 이하로 줄여야 함
    public static void judgmentResultPrint(JudgmentResult judgment) {
        if (judgment.isStrike() && judgment.isBall()) {
            System.out.printf("%d스트라이크 %d볼%n", judgment.getStrike(), judgment.getBall());
            return;
        }

        if (judgment.isStrike()) {
            System.out.printf("%d스트라이크%n", judgment.getStrike());
            return;
        }

        if (judgment.isBall()) {
            System.out.printf("%d볼%n", judgment.getBall());
            return;
        }
        System.out.println("낫싱");
    }

    public static void gameEndPrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public static void reGamePrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
