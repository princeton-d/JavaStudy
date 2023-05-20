package princeton.toy.repository;

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
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @DisplayName("유저 정보 저장")
    @Test
    public void save() throws Exception {
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

    @DisplayName("id로 유저 조회하기(성공)")
    @Test
    public void findById() throws Exception {
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

    @DisplayName("id로 유저 조회하기(없는 id 입력)")
    @Test
    public void findByEmptyId() throws Exception {
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

    @DisplayName("유저 이름으로 유저 조회하기(성공)")
    @Test
    public void findByName() throws Exception {
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

    @DisplayName("유저 이름으로 유저 조회하기(없는 이름으로 조회 진행)")
    @Test
    public void findByEmptyName() throws Exception {
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

    @DisplayName("유저 로그인아이디로 유저 정보 조회하기")
    @Test
    public void findByUserId() throws Exception {
        //given
        User user = User.builder()
                .username("memberA")
                .userLoginId("princeton")
                .userPassword("password")
                .createdAt(LocalDateTime.now())
                .build();
        Long savedId = userRepository.save(user);
        String userLoginId = user.getUserLoginId();

        //when
        User findUser = userRepository.findByUserLoginId(userLoginId).get(0);

        //then
        assertThat(findUser.getUserLoginId()).isEqualTo(userLoginId);
        assertThat(findUser.getId()).isEqualTo(savedId);
    }

    @DisplayName("전체 조회")
    @Test
    public void findAll() throws Exception {
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
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        //when
        List<User> findUsers = userRepository.findAll();

        //then
        assertThat(findUsers.size()).isEqualTo(3);
    }

    @DisplayName("DB가 비어있는 상태에서 전체 조회")
    @Test
    public void findEmptyAll() throws Exception {
        //given

        //when
        List<User> findUsers = userRepository.findAll();

        //then
        assertThat(findUsers).isEmpty();
    }

}