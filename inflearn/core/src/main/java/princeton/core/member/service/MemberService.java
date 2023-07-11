package princeton.core.member.service;

import princeton.core.member.domain.entity.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
