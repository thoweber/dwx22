package guru.thomasweber.dwx22.pbt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import java.util.stream.Stream;

class FactorizerTest {

    static Stream<Arguments> primeFactorSource() {
        return Stream.of(
                Arguments.of(0, List.of(0)),
                Arguments.of(1, List.of(1)),
                Arguments.of(-1, List.of(-1)),
                Arguments.of(-2, List.of(-1, 2)),
                Arguments.of(2, List.of(2)),
                Arguments.of(3, List.of(3)),
                Arguments.of(6, List.of(2, 3)),
                Arguments.of(8, List.of(2, 2, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("primeFactorSource")
    void testFactorize(int number, List<Integer> expected) {
        // when
        var actual = Factorizer.factorize(number);
        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
