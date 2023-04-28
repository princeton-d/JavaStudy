package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createVipOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void createBasicOrder() {
        Long memberId = 2L;
        Member member = new Member(memberId, "memberB", Grade.BASIC);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemB", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(0);
    }
}