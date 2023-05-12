package com.example.jdbcboard.service;

import com.example.jdbcboard.domain.User;
import com.example.jdbcboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        userRepository.save(user);
        return user.getUserId();
    }

    public User findOne(Long userId) {
        return userRepository.findOneUser(userId);
    }

    public List<User> findAll() {
        return userRepository.findAllUser();
    }
}
