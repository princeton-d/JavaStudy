package princeton.securitytest.member.domain.role;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleTest {

    @Test
    @DisplayName("권한 enum 값 테스트")
    void roleTest() throws Exception {
        //given
        Role admin = Role.ADMIN;
        Role member = Role.MEMBER;

        //when
        String adminValue = admin.getValue();
        String memberValue = member.getValue();

        //then
        assertThat(adminValue).isEqualTo("ROLE_ADMIN");
        assertThat(memberValue).isEqualTo("ROLE_MEMBER");
    }

}