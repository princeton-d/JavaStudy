package com.example.jdbcboard.repository;

import com.example.jdbcboard.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

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
