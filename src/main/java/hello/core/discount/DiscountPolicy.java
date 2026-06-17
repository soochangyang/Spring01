package hello.core.discount;

import hello.core.member.Member;
import org.springframework.core.annotation.Order;

public interface DiscountPolicy {
    /**
     *
     * @param member
     * @param price
     * @return 할인대상 금액
     */
    int discount(Member member, int price);
}
