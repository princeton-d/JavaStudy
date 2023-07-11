package princeton.core.discount;

import princeton.core.member.domain.entity.Member;

import static princeton.core.member.domain.role.Grade.*;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == VIP) {
            return price * discountPercent / 100;
        }

        return 0;
    }
}
