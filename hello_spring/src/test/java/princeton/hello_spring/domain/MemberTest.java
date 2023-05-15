package princeton.hello_spring.domain;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberTest {

    @DisplayName("멤버를 생성하고 정보를 입력한다.")
    @Test
    public void createMember() {
        //given, when
        Member member = Member.builder()
                .name("memberA")
                .build();

        //then
        assertThat(member.getId()).isEqualTo(1);
        assertThat(member.getName()).isEqualTo("memberA");
    }

}