package guru.thomasweber.dwx22.pbt;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorizerPBTest {

    @Property
    void productOfNumbersReturnedByFactorizeEqualsNumber(@ForAll int number) {
        // given
        /* Spezialfall number == Integer.MIN_VALUE überspringen */
        if (number == Integer.MIN_VALUE) {
            return;
        }
        /* alle Faktoren aus Factorizer.factorize(number) */
        List<Integer> factors = Factorizer.factorize(number);
        // when
        /* das Produkt aller Faktoren gebildet wird */
        var product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        // then
        /* entspricht das Produkt der der gegebenen Zahl */
        assertEquals(number, product);
    }

    @Test
    void numberOfIntegerMinValueThrowsIllegalArgumentException() {
        // given
        int number = Integer.MIN_VALUE;
        // when/then
        assertThrows(IllegalArgumentException.class, () -> Factorizer.factorize(number));
    }
}
