package princeton.toy.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
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

    @Test
    public void 회원가입() throws Exception {
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

    @Test
    public void id_회원_단건_조회_성공() throws Exception {
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

    @Test
    public void id_회원_단건_조회_빈값() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        Long joinId = userService.join(user);

        //when
        User findUser = userService.findOneUser(2137856L);

        //then
        assertThat(findUser).isNull();
    }

    @Test
    public void 유저명_회원_단건_조회() throws Exception {
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

    @Test
    public void 유저명_회원_단건_조회_빈값() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        Long joinId = userService.join(user);

        //when
        List<User> findUsers = userService.findOneUserByName("세상에 존재할 수 없고 존재해서도 안되는 절대 중복되지 않는 환상적인 이름");

        //then
        assertThat(findUsers).isEmpty();
    }

    @Test
    public void 회원_전체_조회() throws Exception {
        //given
        User user1 = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        User user2 = User.builder()
                .username("memberB")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        User user3 = User.builder()
                .username("memberC")
                .userLoginId("princeton")
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