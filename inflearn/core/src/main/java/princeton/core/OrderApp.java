package princeton.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import princeton.core.config.AppConfig;
import princeton.core.member.domain.entity.Member;
import princeton.core.member.domain.role.Grade;
import princeton.core.member.service.MemberService;
import princeton.core.order.domain.entity.Order;
import princeton.core.order.domain.service.OrderService;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = Member.builder().id(memberId).name("memberA").grade(Grade.VIP).build();
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }

}
