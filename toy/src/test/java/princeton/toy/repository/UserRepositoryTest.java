package princeton.toy.repository;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.domain.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    public void 유저_정보_저장() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        log.info("id={}", user.getId());
        log.info("username={}", user.getUsername());
        log.info("===========================");

        //when
        Long savedId = userRepository.save(user);
        log.info("savedId={}", savedId);
        User findUser = userRepository.find(savedId);
        log.info("findUser.getId={}", findUser.getId());
        log.info("user.getId={}", user.getId());
        log.info("findUser.getUsername={}", findUser.getUsername());
        log.info("user.getUsername={}", user.getUsername());

        //then
        assertThat(findUser.getId()).isEqualTo(user.getId());
        assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    public void 값_있는_id_단건_유저_조회() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        Long savedId = userRepository.save(user);

        //when
        User findUser = userRepository.findById(savedId);

        //then
        assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    public void 값_없는_id_단건_유저_조회() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        Long savedId = userRepository.save(user);

        //when
        User findUser = userRepository.findById(21763L);

        //then
        assertThat(findUser).isNull();
    }

    @Test
    public void 값_있는_유저_이름_단건_조회() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        String username = user.getUsername();
        Long savedId = userRepository.save(user);

        //when
        List<User> findUsers = userRepository.findByName(username);
        User findUser = findUsers.get(0);

        //then
        assertThat(findUser.getId()).isEqualTo(savedId);
        assertThat(findUser.getUsername()).isEqualTo(username);
    }

    @Test
    public void 값_없는_유저_이름_단건_조회() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        userRepository.save(user);

        //when
        List<User> findUser = userRepository.findByName("뉴진스의 하입보이요");

        //then
        assertThat(findUser).isEmpty();
    }

    @Test
    public void 전체_유저_조회() throws Exception {
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
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //when
        List<User> findUsers = userRepository.findAll();

        //then
        assertThat(findUsers.size()).isEqualTo(3);
    }
}