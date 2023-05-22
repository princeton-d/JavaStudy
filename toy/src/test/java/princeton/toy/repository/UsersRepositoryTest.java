package princeton.toy.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.domain.Users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    @DisplayName("유저 정보 저장 테스트")
    public void save() throws Exception {
        //given
        Users user = Users.builder()
                .email("princeton@gmail.com")
                .createdAt(LocalDateTime.now())
                .nickname("princeton")
                .password("password")
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();

        //when
        Long savedId = usersRepository.save(user);

        //then
        assertThat(savedId).isEqualTo(user.getId());
    }

    @Test
    @DisplayName("중복된 닉네임 회원가입 테스트")
    public void duplicateUserSave() throws Exception {
        //given
        Users userA = Users.builder()
                .email("princeton1@gmail.com")
                .createdAt(LocalDateTime.now())
                .nickname("princeton")
                .password("password1")
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();
        usersRepository.save(userA);
        log.info("userA.getId={}", userA.getId());

        Users userB = Users.builder()
                .email("princeton2@gmail.com")
                .createdAt(LocalDateTime.now())
                .nickname("princeton")
                .password("password2")
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();

        //when, then
        assertThatThrownBy(() -> usersRepository.save(userB))
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessage("이미 존재하는 닉네임입니다.");
    }

    @Test
    @DisplayName("id로 유저 조회")
    public void findById() throws Exception {
        //given
        Users user = Users.builder()
                .email("princeton@gmail.com")
                .createdAt(LocalDateTime.now())
                .nickname("princeton")
                .password("password")
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();
        Long savedId = usersRepository.save(user);

        //when
        Users findUser = usersRepository.findById(savedId);

        //then
        assertThat(findUser.getId()).isEqualTo(savedId);
    }

    @Test
    @DisplayName("닉네임으로 유저 조회")
    public void findByNickname() throws Exception {
        //given
        String nickname = "princeton";
        Users user = Users.builder()
                .email("princeton@gmail.com")
                .createdAt(LocalDateTime.now())
                .nickname(nickname)
                .password("password")
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();
        Long savedId = usersRepository.save(user);

        //when
        Users findUser = usersRepository.findByNickname(nickname).get(0);

        //then
        assertThat(findUser.getNickname()).isEqualTo("princeton");
        assertThat(findUser.getId()).isEqualTo(savedId);
    }

    @Test
    @DisplayName("전체 유저 조회")
    public void findAll() throws Exception {
        //given
        Users userA = Users.builder()
                .email("princetonA@gmail.com")
                .createdAt(LocalDateTime.now())
                .nickname("princetonA")
                .password("passwordA")
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();
        usersRepository.save(userA);

        Users userB = Users.builder()
                .email("princetonB@gmail.com")
                .createdAt(LocalDateTime.now())
                .nickname("princetonB")
                .password("passwordB")
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();
        usersRepository.save(userB);

        Users userC = Users.builder()
                .email("princetonC@gmail.com")
                .createdAt(LocalDateTime.now())
                .nickname("princetonC")
                .password("passwordC")
                .articles(new ArrayList<>())
                .comments(new ArrayList<>())
                .build();
        usersRepository.save(userC);

        //when
        List<Users> findUsers = usersRepository.findAll();

        //then
        assertThat(findUsers.size()).isEqualTo(3);
    }

}