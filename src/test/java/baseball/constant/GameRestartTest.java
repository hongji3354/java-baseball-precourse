package baseball.constant;

import static org.assertj.core.api.Assertions.assertThat;

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

}
