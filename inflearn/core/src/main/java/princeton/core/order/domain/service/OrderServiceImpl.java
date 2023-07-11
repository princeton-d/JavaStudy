package princeton.core.order.domain.service;

import princeton.core.discount.DiscountPolicy;
import princeton.core.member.domain.entity.Member;
import princeton.core.member.repository.MemberRepository;
import princeton.core.order.domain.entity.Order;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return Order.builder()
                .memberId(memberId)
                .itemName(itemName)
                .itemPrice(itemPrice)
                .discountPrice(discountPrice)
                .build();
    }
}
