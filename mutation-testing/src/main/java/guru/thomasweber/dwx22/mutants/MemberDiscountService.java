package guru.thomasweber.dwx22.mutants;

import java.math.BigDecimal;

public class MemberDiscountService {

    private BigDecimal minOrderAmount = new BigDecimal("50.00");
    private BigDecimal memberDiscount = new BigDecimal("0.10");

    public BigDecimal computeMemberDiscount(Order order, User user) {
        if (user.isMember() && minOrderAmount.compareTo(order.getOrderTotal()) < 0) {
            return order.getOrderTotal().multiply(memberDiscount).setScale(2);
        }
        return BigDecimal.ZERO;
    }
}
