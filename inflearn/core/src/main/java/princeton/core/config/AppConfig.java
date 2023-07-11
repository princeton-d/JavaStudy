package princeton.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import princeton.core.discount.DiscountPolicy;
import princeton.core.discount.RateDiscountPolicy;
import princeton.core.member.repository.MemberRepository;
import princeton.core.member.repository.MemoryMemberRepository;
import princeton.core.member.service.MemberService;
import princeton.core.member.service.MemberServiceImpl;
import princeton.core.order.domain.service.OrderService;
import princeton.core.order.domain.service.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
