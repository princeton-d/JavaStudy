package princeton.toy.member.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.member.domain.exception.DuplicateLoginIdException;
import princeton.toy.member.domain.entity.Member;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    public void save() throws Exception {
        //given
        String loginId = "princeton";
        String email = "princeton@test.com";
        LocalDateTime createdAt = LocalDateTime.now();
        String password = "password";

        Member member = new Member(loginId, email, createdAt, password);

        //when
        Long savedId = memberRepository.save(member);

        //then
        assertThat(savedId).isEqualTo(member.getId());
    }

    @Test
    public void findById() throws Exception {
        //given
        String loginId = "princeton";
        String email = "princeton@test.com";
        LocalDateTime createdAt = LocalDateTime.now();
        String password = "password";

        Member member = new Member(loginId, email, createdAt, password);
        memberRepository.save(member);

        //when
        Member findMember = memberRepository.findById(member.getId());

        //then
        assertThat(findMember).isEqualTo(member);
    }

    //    @Test
//    @DisplayName("중복된 로그인 아이디로 회원가입 테스트")
//    public void duplicateLoginIdSave() throws Exception {
//        //given
//        String duplicateLoginId = "princeton";
//        String email = "princeton@test.com";
//        LocalDateTime createdAt = LocalDateTime.now();
//        String password = "password";
//
//        Member member = new Member(duplicateLoginId, email, createdAt, password);
//        memberRepository.save(member);
//
//        String anotherEmail = "another@test.com";
//        LocalDateTime anotherCreatedAt = LocalDateTime.now();
//        String anotherPassword = "another";
//
//        Member duplicateLoginIdMember = new Member(duplicateLoginId, anotherEmail, anotherCreatedAt, anotherPassword);
//
//        //when, then
//        assertThatThrownBy(() -> memberRepository.save(duplicateLoginIdMember))
//                .isInstanceOf(DuplicateLoginIdException.class)
//                .hasMessage("이미 가입된 아이디입니다.");
//    }

}