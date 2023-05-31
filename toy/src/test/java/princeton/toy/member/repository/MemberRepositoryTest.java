package princeton.toy.member.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.member.domain.exception.DuplicateLoginIdException;
import princeton.toy.member.domain.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    public void save() throws Exception {
        //given
        Member member = new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password");

        //when
        Long savedId = memberRepository.save(member);

        //then
        assertThat(savedId).isEqualTo(member.getId());
    }

    @Test
    @DisplayName("중복된 로그인 아이디로 회원가입 테스트")
    public void duplicateLoginIdSave() throws DuplicateLoginIdException {
        //given
        String duplicateLoginId = "princeton";

        Member member = new Member(duplicateLoginId, "princeton@test.com", LocalDateTime.now(), "password");
        memberRepository.save(member);

        Member duplicateLoginIdMember = new Member(duplicateLoginId, "another@test.com", LocalDateTime.now(), "another");

        //when, then
        assertThatThrownBy(() -> memberRepository.save(duplicateLoginIdMember))
                .isInstanceOf(DuplicateLoginIdException.class)
                .hasMessage("이미 가입된 아이디입니다.");
    }

    @Test
    public void findById() throws Exception {
        //given
        Member member = new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password");
        memberRepository.save(member);

        //when
        Member findMember = memberRepository.findById(member.getId());

        //then
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    public void findByLoginId() throws Exception {
        //given
        String loginId = "princeton";

        Member member = new Member(loginId, "princeton@test.com", LocalDateTime.now(), "password");
        memberRepository.save(member);

        //when
        Member findMember = memberRepository.findByLoginId(loginId).get(0);

        //then
        assertThat(findMember.getLoginId()).isEqualTo(loginId);
    }

    @Test
    public void findByNotExistLoginId() throws Exception {
        //given
        Member member = new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password");
        memberRepository.save(member);

        //when
        List<Member> findMembers = memberRepository.findByLoginId("thisIsNotExistLoginId");

        //then
        assertThat(findMembers).isEmpty();
    }

    @Test
    public void findAll() throws Exception {
        //given
        Member memberA = new Member("loginId1", "email1", LocalDateTime.now(), "password1");
        Member memberB = new Member("loginId2", "email2", LocalDateTime.now(), "password2");
        Member memberC = new Member("loginId3", "email3", LocalDateTime.now(), "password3");
        memberRepository.save(memberA);
        memberRepository.save(memberB);
        memberRepository.save(memberC);

        //when
        List<Member> findMembers = memberRepository.findAll();

        //then
        assertThat(findMembers.size()).isEqualTo(3);
    }

}