package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.constant.PlayerErrorMessage;
import baseball.domain.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerInputConsoleTest {


    void scannerInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void 세자리_수_입력(String inputNumber) {
        scannerInput(inputNumber);

        final Player player = PlayerInputConsole.inputNumber();

        assertThat(player.getPickNumber().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","12","1234"})
    void 세자리_수가_아닐_시_예외(String inputNumber) {
        scannerInput(inputNumber);

        assertThatThrownBy(PlayerInputConsole::inputNumber)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(PlayerErrorMessage.DIGIT_RANGE_OUT.getErrorMessage());
    }

    @Test
    void 입력된_숫자들은_서로_다른_숫자() {
        scannerInput("123");

        final Player player = PlayerInputConsole.inputNumber();
        assertThat(player.getPickNumber()).containsExactly(1,2,3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"111","112","122"})
    void 입력된_숫자가_깉을시_예외(String inputNumber) {
        scannerInput(inputNumber);

        assertThatThrownBy(PlayerInputConsole::inputNumber)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(PlayerErrorMessage.DUPLICATE_NUMBER.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"가23", "1가3", "12가"})
    void 숫자가_아닌_문자_입력시_예외(String inputNumber) {
        scannerInput(inputNumber);

        assertThatThrownBy(PlayerInputConsole::inputNumber)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(PlayerErrorMessage.NOT_NUMBER.getErrorMessage());
    }

    @Test
    void 범위를_벗어난_숫자_입력시_예외() {
        scannerInput("012");

        assertThatThrownBy(PlayerInputConsole::inputNumber)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(PlayerErrorMessage.NUMBER_RANGE_OUT.getErrorMessage());
    }
}