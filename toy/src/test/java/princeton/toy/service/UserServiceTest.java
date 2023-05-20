package princeton.toy.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.domain.User;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired private UserService userService;

    @DisplayName("회원가입")
    @Test
    public void join() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();

        //when
        Long joinId = userService.join(user);

        //then
        assertThat(joinId).isEqualTo(user.getId());
    }

    @DisplayName("동일한 userId로 회원가입 시도 테스트")
    @Test
    public void duplicateUserIdTest() throws Exception {
        //given
        User user1 = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password1")
                .createdAt(LocalDateTime.now())
                .build();
        User user2 = User.builder()
                .username("memberB")
                .userLoginId("princeton")
                .userPassword("password2")
                .createdAt(LocalDateTime.now())
                .build();

        userService.join(user1);

        //when, then
        assertThatThrownBy(() -> {
            userService.join(user2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 존재하는 아이디입니다.");
    }

    @DisplayName("id로 유저 단건 조회")
    @Test
    public void findOneUser() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        Long joinId = userService.join(user);

        //when
        User findUser = userService.findOneUser(joinId);

        //then
        assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
        assertThat(findUser.getId()).isEqualTo(user.getId());
    }

    @DisplayName("유저명으로 회원 단건 조회")
    @Test
    public void findOneUserByName() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        Long joinId = userService.join(user);

        //when
        User findUser = userService.findOneUserByName(user.getUsername()).get(0);

        //then
        assertThat(findUser.getId()).isEqualTo(joinId);
        assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
    }

    @DisplayName("전체 회원 조회")
    @Test
    public void findUsers() throws Exception {
        //given
        User user1 = User.builder()
                .username("memberA")
                .userLoginId("princetonA")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        User user2 = User.builder()
                .username("memberB")
                .userLoginId("princetonB")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        User user3 = User.builder()
                .username("memberC")
                .userLoginId("princetonC")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        userService.join(user1);
        userService.join(user2);
        userService.join(user3);

        //when
        List<User> findUsers = userService.findUsers();

        //then
        assertThat(findUsers.size()).isEqualTo(3);
    }

}