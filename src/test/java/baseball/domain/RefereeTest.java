package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import baseball.view.PlayerNumberInputConsole;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class RefereeTest {

    @Test
    void 스트라이크_판정() {
        try(MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(9,2,7);

            InputStream in = new ByteArrayInputStream("914".getBytes(StandardCharsets.UTF_8));
            System.setIn(in);

            final Computer computer = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();
            final Player player = PlayerNumberInputConsole.inputNumber();

            final JudgmentResult judgment = Referee.judgment(computer, player);

            assertThat(judgment.getStrike()).isEqualTo(1);
        }
    }

    @Test
    void 볼_판정() {
        try(MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1,5,8);

            InputStream in = new ByteArrayInputStream("914".getBytes(StandardCharsets.UTF_8));
            System.setIn(in);

            final Computer computer = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();
            final Player player = PlayerNumberInputConsole.inputNumber();

            final JudgmentResult judgment = Referee.judgment(computer, player);

            assertThat(judgment.getBall()).isEqualTo(1);
        }
    }

    @Test
    void 스트라이크_볼_판정() {
        try(MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(8,4,1);

            InputStream in = new ByteArrayInputStream("815".getBytes(StandardCharsets.UTF_8));
            System.setIn(in);

            final Computer computer = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();
            final Player player = PlayerNumberInputConsole.inputNumber();

            final JudgmentResult judgment = Referee.judgment(computer, player);

            assertThat(judgment.getStrike()).isEqualTo(1);
            assertThat(judgment.getBall()).isEqualTo(1);
        }
    }

    @Test
    void 낫싱_판정() {
        try(MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1,2,3);

            InputStream in = new ByteArrayInputStream("456".getBytes(StandardCharsets.UTF_8));
            System.setIn(in);

            final Computer computer = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();
            final Player player = PlayerNumberInputConsole.inputNumber();

            final JudgmentResult judgment = Referee.judgment(computer, player);

            assertThat(judgment.getStrike()).isZero();
            assertThat(judgment.getBall()).isZero();
        }
    }
}
