package guru.thomasweber.dwx22.mutants;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberDiscountServiceTest {

    @Test
    void membersReceiveDiscountIfOrderAboveMinValue() {
        // given
        /*
         - User ist Member
         - Order-Total ist 55.00
         */
        // when
        /* MemberDiscountService berechnet Discount */
              // then
        /* Discount entspricht 5.50 */
    }

    @Test
    void membersDoNotReceiveDiscountIfOrderBelowMinValue() {
        // given
        /*
         - User ist Member
         - Order-Total ist 45.00
         */
        // when
        /* MemberDiscountService berechnet Discount */
        // then
        /* Discount entspricht 0 */
    }

    @Test
    void nonMembersDoNotReceiveDiscountIfOrderAboveMinValue() {
        // given
         /*
         - User ist kein Member
         - Order-Total ist 55.00
         */
        // when
        /* MemberDiscountService berechnet Discount */
        // then
        /* Discount entspricht 0 */
    }

}
