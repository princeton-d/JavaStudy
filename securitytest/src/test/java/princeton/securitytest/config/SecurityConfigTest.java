package princeton.securitytest.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SecurityConfigTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("비밀번호 인코딩 테스트")
    void passwordEncoderTest() throws Exception {
        //given
        String password = "password";

        //when
        String encodedPassword = passwordEncoder.encode(password);
        boolean matches = passwordEncoder.matches(password, encodedPassword);

        //then
        assertThat(encodedPassword).isNotEqualTo(password);
        assertThat(matches).isTrue();
    }

}