package guru.thomasweber.dwx22.pbt;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorizerPBTest {

    @Property
    void productOfNumbersReturnedByFactorizeEqualsNumber(@ForAll int number) {
        // given
        /* alle Faktoren aus Factorizer.factorize(number) */
        // when
        /* das Produkt aller Faktoren gebildet wird */
        // then
        /* entspricht das Produkt der der gegebenen Zahl */
    }

}
