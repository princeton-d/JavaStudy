package princeton.securitytest.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import princeton.securitytest.member.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
