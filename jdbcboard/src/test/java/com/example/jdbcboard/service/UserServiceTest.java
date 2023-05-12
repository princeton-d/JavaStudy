package com.example.jdbcboard.service;

import com.example.jdbcboard.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
//    @Rollback(false)
    public void join(){
        //given
        User user = new User();
        Long userId = userService.join(user);

        //when
        User findUser = userService.findOne(userId);

        //then
        assertThat(findUser.getUserId()).isEqualTo(userId);
    }

    @Test
    public void findAllUsers() {
        //given
        User user1 = new User();
        User user2 = new User();
        userService.join(user1);
        userService.join(user2);

        //when
        List<User> findUsers = userService.findAll();

        //then
        assertThat(findUsers.size()).isEqualTo(2);
    }

}