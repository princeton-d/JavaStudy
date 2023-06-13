package princeton.princeton.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import princeton.princeton.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
