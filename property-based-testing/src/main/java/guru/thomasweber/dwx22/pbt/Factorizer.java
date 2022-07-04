package guru.thomasweber.dwx22.pbt;

import java.util.ArrayList;
import java.util.List;

public class Factorizer {

    private static final List<Integer> SPECIAL_CASES = List.of(-1, 0, 1);

    public static List<Integer> factorize(int number) {
        if (SPECIAL_CASES.contains(number)) {
            return List.of(number);
        }
        if (Integer.MIN_VALUE == number) {
            throw new IllegalArgumentException("Integer.MIN_VALUE cannot be factorized");
        }
        if (number < 0) {
            var factors = new ArrayList<Integer>();
            factors.add(-1);
            factors.addAll(factorize((-1) * number));
            return factors;
        }

        var factors = new ArrayList<Integer>();
        // treat factor 2 separately
        while (number % 2 == 0) {
            factors.add(2);
            number /= 2;
        }

        // check all uneven number up to the square root of number
        for (var i = 3; i <= Math.ceil(Math.sqrt(number)) + 1; i += 2) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }
        /*
         durch property-based Test gefundener Fehler: wenn hier ein Rest ungleich 1 überig bleibt, liegt eine
         weitere Primzahl vor
         */
        if (number!=1) {
            factors.add(number);
        }
        return factors;
    }
}
