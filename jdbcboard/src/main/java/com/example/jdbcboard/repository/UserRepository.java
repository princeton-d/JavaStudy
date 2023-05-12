package com.example.jdbcboard.repository;

import com.example.jdbcboard.domain.User;

import java.util.List;

public interface UserRepository {

    Long save(User user);

    User findOneUser(Long userId);

    List<User> findAllUser();

}
