package princeton.hello_spring.domain;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import princeton.hello_spring.exception.AlreadyRegisteredException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberTest {

    @DisplayName("멤버를 생성하고 정보를 입력한다.")
    @Test
    public void createMember() throws Exception {
        //given
        Member member = new Member();

        //when
        member.createMemberInfo(1L, "memberA");

        //then
        assertThat(member.getId()).isEqualTo(1);
        assertThat(member.getName()).isEqualTo("memberA");
    }

    @DisplayName("회원정보를 입력한 후에 다시 입력할 수 없어야한다.")
    @Test
    public void createMemberInfo() throws AlreadyRegisteredException {
        //given
        Member member = new Member();
        member.createMemberInfo(1L, "member1");
        log.info("memberId={}, memberName={}", member.getId(), member.getName());

        //when, then
        assertThatThrownBy(() -> member.createMemberInfo(2L, "member2"))
                .isInstanceOf(AlreadyRegisteredException.class)
                .hasMessage("한번 등록한 회원정보는 다시 등록할 수 없습니다.");
    }

}