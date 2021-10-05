package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.constant.PlayerErrorMessage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class PlayerReGameInputConsoleTest {

    void scannerInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
    }

    @Test
    void 게임_종료_후_1을_입력할_경우_게임_다시_시작() {
        scannerInput("1");

        assertThat(PlayerReGameInputConsole.reGame()).isTrue();
    }

    @Test
    void 게임_종료_후_2를_입력할_경우_게임_다시_시작_안함() {
        scannerInput("2");

        assertThat(PlayerReGameInputConsole.reGame()).isFalse();
    }

    @Test
    void 숫자_1_또는_2가_들어올_시_예외() {
        scannerInput("3");

        assertThatThrownBy(PlayerReGameInputConsole::reGame)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(PlayerErrorMessage.RE_GAME_INPUT_ERROR.getErrorMessage());
    }

}
