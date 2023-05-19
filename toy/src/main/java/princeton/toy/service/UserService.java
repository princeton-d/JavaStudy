package princeton.toy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.domain.User;
import princeton.toy.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public Long join(User user) {
        return userRepository.save(user);
    }

    public User findOneUser(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> findOneUserByName(String username) {
        return userRepository.findByName(username);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
