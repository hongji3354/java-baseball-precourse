package baseball.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameRestartTest {

    @Test
    void 숫자_1은_YES() {
        assertThat(GameRestart.of("1")).isEqualTo(GameRestart.YES);
    }

    @Test
    void 숫자_2는_NO() {
        assertThat(GameRestart.of("2")).isEqualTo(GameRestart.NO);
    }

    @Test
    void 숫자_1_또는_2가_아닐시_예외() {
        assertThatThrownBy(() -> GameRestart.of("가"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(PlayerErrorMessage.RE_GAME_INPUT_ERROR.getErrorMessage());
    }
}
