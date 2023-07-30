package princeton.securitytest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import princeton.securitytest.member.domain.entity.Member;
import princeton.securitytest.member.service.MemberService;

@Slf4j
@SpringBootTest
public class ConcurrencyTest {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    MemberService memberService;

    @Test
    void ConcurrencyLockTest() throws Exception {
        
    }

}
