package princeton.core.discount;

import princeton.core.member.domain.entity.Member;
import princeton.core.member.domain.role.Grade;

import static princeton.core.member.domain.role.Grade.*;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == VIP) {
            return discountFixAmount;
        }

        return 0;
    }
}
