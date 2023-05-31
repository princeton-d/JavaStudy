package princeton.toy.member.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.repository.MemberRepository;
import princeton.toy.member.service.MemberService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        Long savedId = memberRepository.save(member);
        return savedId;
    }

    @Override
    public Member findMemberById(Long id) {
        Member findMember = memberRepository.findById(id);
        return findMember;
    }

    @Override
    public List<Member> findMemberByLoginId(String loginId) {
        List<Member> findMembers = memberRepository.findByLoginId(loginId);
        return findMembers;
    }

    @Override
    public List<Member> findMembers() {
        List<Member> findMembers = memberRepository.findAll();
        return findMembers;
    }
}
