package com.example.jdbcboard.repository;

import com.example.jdbcboard.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class JpaUserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void save() throws Exception {
        //given
        User user = new User();
        Long savedId = userRepository.save(user);

        //when
        User findUser = userRepository.findOneUser(savedId);

        //then
        assertThat(findUser.getUserId()).isEqualTo(savedId);
    }

    @Test
    public void findAll() throws Exception {
        //given
        User user1 = new User();
        User user2 = new User();
        userRepository.save(user1);
        userRepository.save(user2);

        //when
        List<User> findUserList = userRepository.findAllUser();

        //then
        assertThat(findUserList.size()).isEqualTo(2);
    }

}