package princeton.core.scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import princeton.core.AutoAppConfig;
import princeton.core.member.service.MemberService;
import princeton.core.order.domain.service.OrderService;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        applicationContext.getBean(MemberService.class);
        applicationContext.getBean(OrderService.class);
    }

}
