package princeton.toy.member.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.domain.exception.DuplicateLoginIdException;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        validateDuplicateLoginId(member.getLoginId());
        em.persist(member);
        return member.getId();
    }

    private void validateDuplicateLoginId(String loginId) {
        if (isExistDuplicateLoginId(loginId)) {
            throw new DuplicateLoginIdException("이미 가입된 아이디입니다.");
        }
    }

    private boolean isExistDuplicateLoginId(String loginId) {
        return !findByLoginId(loginId).isEmpty();
    }

    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findByLoginId(String loginId) {
        return em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
