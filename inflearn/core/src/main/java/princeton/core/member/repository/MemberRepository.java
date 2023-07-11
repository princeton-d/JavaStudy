package princeton.core.member.repository;

import princeton.core.member.domain.entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
