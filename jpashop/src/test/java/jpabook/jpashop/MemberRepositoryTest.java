package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() throws Exception {
        // given
        Member memberA = new Member();
        memberA.setUsername("memberA");
        Member memberB = new Member();
        memberB.setUsername("memberB");
        // when
        Long savedMemberAId = memberRepository.save(memberA);
        Member findMemberA = memberRepository.find(savedMemberAId);
        Long savedMemberBId = memberRepository.save(memberB);
        Member findMemberB = memberRepository.find(savedMemberBId);

        //then
        assertThat(findMemberA.getId()).isEqualTo(memberA.getId());
        assertThat(findMemberA.getUsername()).isEqualTo(memberA.getUsername());
        assertThat(findMemberA).isEqualTo(memberA);

        assertThat(findMemberB.getId()).isNotEqualTo(memberA.getId());
        assertThat(findMemberB.getUsername()).isNotEqualTo(memberA.getUsername());
        assertThat(memberB).isNotEqualTo(memberA);
    }
}