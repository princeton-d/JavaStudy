package princeton.hello_spring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import princeton.hello_spring.domain.Member;
import princeton.hello_spring.exception.AlreadyRegisteredException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @DisplayName("유저 정보를 저장한다.")
    @Test
    public void save() throws Exception {
        //given
        Member member = new Member();
        String memberName = "memberA";

        //when
        Member saveMember = memberRepository.save(member, memberName);

        //then
        assertThat(saveMember.getName()).isEqualTo(memberName);
        assertThat(saveMember).isEqualTo(member);
    }

    @DisplayName("id를 통해 유저를 찾는다. 없는 id라면 빈 값을 반환한다.")
    @Test
    public void findById() throws AlreadyRegisteredException {
        //given
        Member member = new Member();
        Member savedMember = memberRepository.save(member, "member1");

        //when
        Optional<Member> findMember = memberRepository.findById(member.getId());
        Optional<Member> nullMember = memberRepository.findById(2L);

        //then
        assertThat(findMember.get()).isEqualTo(savedMember);
        assertThat(nullMember).isEqualTo(Optional.empty());
    }

    @DisplayName("멤버의 이름를 통해 유저를 찾는다. 없는 이름이라면 빈 값을 반환한다.")
    @Test
    public void findByName() throws Exception {
        //given
        Member member = new Member();
        Member savedMember = memberRepository.save(member, "member");

        //when
        Optional<Member> findMember = memberRepository.findByName("member");
        Optional<Member> nullMember = memberRepository.findByName("nuneMember");

        //then
        assertThat(findMember.get()).isEqualTo(savedMember);
        assertThat(nullMember).isEqualTo(Optional.empty());
    }

    @DisplayName("모든 멤버를 조회한다.")
    @Test
    public void findAll() throws Exception {
        //given
        Member member1 = new Member();
        memberRepository.save(member1, "member");
        Member member2 = new Member();
        memberRepository.save(member2, "member");

        //when
        List<Member> findMembers = memberRepository.findAll();

        //then
        assertThat(findMembers.size()).isEqualTo(2);
    }

}