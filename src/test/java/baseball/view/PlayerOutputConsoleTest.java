package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.JudgmentResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerOutputConsoleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void 스트라이크_볼_출력() {
        final JudgmentResult judgmentResult = new JudgmentResult();
        judgmentResult.addStrike();
        judgmentResult.addBall();

        PlayerOutputConsole.print(judgmentResult);
        assertThat(outContent.toString().trim()).isEqualTo("1스트라이크 1볼");
    }

    @Test
    void 스트라이크_출력() {
        final JudgmentResult judgmentResult = new JudgmentResult();
        judgmentResult.addStrike();

        PlayerOutputConsole.print(judgmentResult);
        assertThat(outContent.toString().trim()).isEqualTo("1스트라이크");
    }

    @Test
    void 볼_출력() {
        final JudgmentResult judgmentResult = new JudgmentResult();
        judgmentResult.addBall();

        PlayerOutputConsole.print(judgmentResult);
        assertThat(outContent.toString().trim()).isEqualTo("1볼");
    }

    @Test
    void 낫싱_출력() {
        final JudgmentResult judgmentResult = new JudgmentResult();

        PlayerOutputConsole.print(judgmentResult);
        assertThat(outContent.toString().trim()).isEqualTo("낫싱");
    }

    @Test
    void 게임_종료_출력() {
        PlayerOutputConsole.gameEndPrint();

        assertThat(outContent.toString().trim()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    @Test
    void 게임_재시작_여부_출력() {
        PlayerOutputConsole.reGamePrint();

        assertThat(outContent.toString().trim()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
