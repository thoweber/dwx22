package guru.thomasweber.dwx22.mutants;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberDiscountServiceTest {

    @Test
    void membersReceiveDiscountIfOrderAboveMinValue() {
        // given
        User user = User.builder().member(true).build();
        Order order = Order.builder().orderTotal(new BigDecimal("55.00")).build();
        MemberDiscountService memberDiscountService = new MemberDiscountService();
        // when
        BigDecimal discount = memberDiscountService.computeMemberDiscount(order, user);
        // then
        assertEquals(new BigDecimal("5.50"), discount);
    }

    @Test
    void membersDoNotReceiveDiscountIfOrderBelowMinValue() {
        // given
        User user = User.builder().member(true).build();
        /* Prüfwert genau auf Grenzwert gelegt um den Mutanten zu töten */
        Order order = Order.builder().orderTotal(new BigDecimal("50.00")).build();
        MemberDiscountService memberDiscountService = new MemberDiscountService();
        // when
        BigDecimal discount = memberDiscountService.computeMemberDiscount(order, user);
        // then
        assertEquals(BigDecimal.ZERO, discount);
    }

    @Test
    void nonMembersDoNotReceiveDiscountIfOrderAboveMinValue() {
        // given
        User user = User.builder().member(false).build();
        Order order = Order.builder().orderTotal(new BigDecimal("55.00")).build();
        MemberDiscountService memberDiscountService = new MemberDiscountService();
        // when
        BigDecimal discount = memberDiscountService.computeMemberDiscount(order, user);
        // then
        assertEquals(BigDecimal.ZERO, discount);
    }

}
