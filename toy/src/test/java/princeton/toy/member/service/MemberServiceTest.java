package princeton.toy.member.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.member.domain.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberservice;

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password");

        //when
        Long savedId = memberservice.join(member);

        //then
        assertThat(savedId).isEqualTo(member.getId());
    }

    @Test
    public void findMemberById() throws Exception {
        //given
        Long savedId = memberservice.join(new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password"));

        //when
        Member findMember = memberservice.findMemberById(savedId);

        //then
        assertThat(findMember.getId()).isEqualTo(savedId);
    }

    @Test
    public void findMemberByLoginId() throws Exception {
        //given
        String loginId = "princeton";

        memberservice.join(new Member(loginId, "princeton@test.com", LocalDateTime.now(), "password"));

        //when
        Member findMember = memberservice.findMemberByLoginId(loginId).get(0);

        //then
        assertThat(findMember.getLoginId()).isEqualTo(loginId);
    }

    @Test
    public void findMembers() throws Exception {
        //given
        memberservice.join(new Member("princetonA", "princetonA@test.com", LocalDateTime.now(), "passwordA"));
        memberservice.join(new Member("princetonB", "princetonB@test.com", LocalDateTime.now(), "passwordB"));

        //when
        List<Member> findMembers = memberservice.findMembers();

        //then
        assertThat(findMembers.size()).isEqualTo(2);
    }

}