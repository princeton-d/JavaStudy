package princeton.toy.domain;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@Slf4j
class UsersTest {

    @Test
    @DisplayName("Users 엔티티 생성 테스트")
    public void create() throws Exception {
        //given
        String email = "princeton@gmail.com";
        String nickname = "princeton";
        String password = "password";
        LocalDateTime createdAt = LocalDateTime.now();

        //when
        Users createUser = Users.builder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .createdAt(createdAt)
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();

        log.info("id={}", createUser.getId());
        log.info("email={}", createUser.getEmail());
        log.info("password={}", createUser.getPassword());
        log.info("createdAt={}", createUser.getCreatedAt());
        log.info("articles={}", createUser.getArticles());

        //then
        assertThat(createUser.getId()).isNull();
        assertThat(createUser.getEmail()).isEqualTo(email);
        assertThat(createUser.getNickname()).isEqualTo(nickname);
        assertThat(createUser.getPassword()).isEqualTo(password);
        assertThat(createUser.getCreatedAt()).isEqualTo(createdAt);
        assertThat(createUser.getArticles()).isEmpty();
    }

}