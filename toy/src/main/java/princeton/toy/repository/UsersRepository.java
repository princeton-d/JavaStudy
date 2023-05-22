package princeton.toy.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import princeton.toy.domain.Users;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UsersRepository {

    private final EntityManager em;

    public Long save(Users user) {
        validateDuplicateNickname(user);
        log.info("user={}", user);
        em.persist(user);
        return user.getId();
    }

    private void validateDuplicateNickname(Users user) {
        String nickname = user.getNickname();
        if (isNotExistNickname(nickname)) {
            throw new DataIntegrityViolationException("이미 존재하는 닉네임입니다.");
        }
    }

    private boolean isNotExistNickname(String nickname) {
        return !findByNickname(nickname).isEmpty();
    }

    public Users findById(Long userId) {
        return em.find(Users.class, userId);
    }

    public List<Users> findAll() {
        return em.createQuery("select u from Users u", Users.class).getResultList();
    }

    public List<Users> findByNickname(String nickname) {
        return em.createQuery("select u from Users u where u.nickname = :nickname", Users.class)
                .setParameter("nickname", nickname)
                .getResultList();
    }
}
