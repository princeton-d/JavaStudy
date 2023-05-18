package princeton.toy.repository;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.domain.User;

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
        User user = User.builder().username("memberA").build();
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

}