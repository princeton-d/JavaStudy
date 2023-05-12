package com.example.jdbcboard.repository;

import com.example.jdbcboard.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class JdbcUserRepositoryTest {

    UserRepository repository = new JdbcUserRepository();

    @Test
    public void crud() throws SQLException {
        User user = new User("memberA", "princeton@gmail.com", "password", LocalDateTime.now());
        User saveUser = repository.save(user);

        assertThat(saveUser).isEqualTo(user);
    }

}