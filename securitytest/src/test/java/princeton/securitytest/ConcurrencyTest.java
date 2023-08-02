package princeton.securitytest;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import princeton.securitytest.member.domain.entity.Member;
import princeton.securitytest.member.repository.MemberRepository;
import princeton.securitytest.member.service.MemberService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SpringBootTest
public class ConcurrencyTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void ConcurrencyLockTest() throws InterruptedException {

        Member member = Member.builder().testValue(10000L).build();
        Long joinMemberId = memberService.join(member).getId();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CountDownLatch latch = new CountDownLatch(2);

        executorService.execute(() -> {
            memberService.updateMember(joinMemberId, 10000L);
            latch.countDown();
        });

        executorService.execute(() -> {
            memberService.updateMember(joinMemberId, 20000L);
            latch.countDown();
        });

        latch.await();

        Assertions.assertThat(memberRepository.findById(joinMemberId).get().getTestValue()).isEqualTo(30000);

    }

}
