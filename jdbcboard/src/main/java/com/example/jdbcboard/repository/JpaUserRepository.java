package com.example.jdbcboard.repository;

import com.example.jdbcboard.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    @Override
    public Long save(User user) {
        user.pushCreatedAt();
        em.persist(user);

        return user.getUserId();
    }

    @Override
    public User findOneUser(Long userId) {
        return em.find(User.class, userId);
    }

    @Override
    public List<User> findAllUser() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }
}
