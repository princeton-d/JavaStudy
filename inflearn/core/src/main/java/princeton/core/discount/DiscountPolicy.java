package princeton.core.discount;

import princeton.core.member.domain.entity.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
