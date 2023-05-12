package com.example.jdbcboard.repository;

import com.example.jdbcboard.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    User save(User user) throws SQLException;

    User findOneUser(Long userId);

    List<User> findAllUser();

}
