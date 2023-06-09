package princeton.toy.member.service;

import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.dto.MemberListDto;

import java.util.List;

public interface MemberService {

    Long join(Member member);

    Member findMemberById(Long id);

    List<Member> findMemberByLoginId(String loginId);

    List<Member> findMembers();

    MemberListDto findMembersDto();
}
