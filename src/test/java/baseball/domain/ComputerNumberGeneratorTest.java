package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import baseball.constant.GameNumberRule;
import java.util.HashSet;
import java.util.List;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class ComputerNumberGeneratorTest {

    @Test
    void 숫자_1부터_9사이_생성() {
        List<Integer> numbers = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();
        for (Integer number : numbers) {
            assertThat(number).isBetween(GameNumberRule.START_INCLUSIVE.getNumber(),
                GameNumberRule.END_INCLUSIVE.getNumber());
        }
    }

    @Test
    void 세자리수_숫자_생성() {
        List<Integer> numbers = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    void 생성된_숫자들은_서로_다른_숫자() {
        List<Integer> numbers = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();
        HashSet<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        assertThat(numbers.size()).isEqualTo(nonDuplicateNumbers.size());
    }

    @Test
    void 생성된_숫자에_새로운_숫자_추가_불가() {
        List<Integer> numbers = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();

        assertThatThrownBy(() -> numbers.add(10))
            .isInstanceOf(UnsupportedOperationException.class);
    }
    
    @Test
    void 랜덤으로_생성된_숫자_순서_보장() {
        try(MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(9,2,7);

            List<Integer> numbers = ComputerNumberGenerator.createNonDuplicateThreeDigitNumber();

            assertThat(numbers.get(0)).isEqualTo(9);
            assertThat(numbers.get(1)).isEqualTo(2);
            assertThat(numbers.get(2)).isEqualTo(7);
        }
    }
}
