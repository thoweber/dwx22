package guru.thomasweber.dwx22.mutants;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Order {
    /*
    andere Eigenschaften wurden ausgelassen
     */
    private BigDecimal orderTotal;
}
