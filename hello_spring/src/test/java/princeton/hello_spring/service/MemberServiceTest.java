package princeton.hello_spring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import princeton.hello_spring.domain.Member;
import princeton.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired private MemberService memberService;
    @Autowired private MemoryMemberRepository memberRepository;

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @DisplayName("회원가입")
    @Test
    public void join() throws Exception {
        //given
        Member member = new Member();
        String memberName = "member1";

        //when
        Long joinId = memberService.join(member, memberName);

        //then
        assertThat(joinId).isEqualTo(1);
    }

    @DisplayName("중복 회원 예외")
    @Test
    public void duplicateMember() throws Exception {
        //given
        Member member1 = new Member();
        String memberName1 = "member1";
        memberService.join(member1, memberName1);
        Member member2 = new Member();
        String memberName2 = "member1";

        //when, then
        assertThatThrownBy(() -> memberService.join(member2, memberName2))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이미 존재하는 이름입니다. 이름: " + memberName2);

//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2, memberName2));
//        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다. 이름: " + memberName2);
    }

    @DisplayName("전체 조회")
    @Test
    public void findAllMembers() throws Exception {
        //given
        Member member1 = new Member();
        String memberName1 = "member1";
        memberService.join(member1, memberName1);
        Member member2 = new Member();
        String memberName2 = "member2";
        memberService.join(member2, memberName2);

        //when
        List<Member> members = memberService.findAllMembers();

        //then
        assertThat(members.size()).isEqualTo(2);
    }

    @DisplayName("단건 조회")
    @Test
    public void findOndMember() throws Exception {
        //given
        Member member = new Member();
        String memberName = "member1";
        memberService.join(member, memberName);

        //when
        Optional<Member> findMember = memberService.findOndMember(member.getId());
        Optional<Member> emptyMember = memberService.findOndMember(9999999L);

        //then
        assertThat(findMember.get()).isEqualTo(member);
        assertThat(emptyMember).isEqualTo(Optional.empty());
    }
}