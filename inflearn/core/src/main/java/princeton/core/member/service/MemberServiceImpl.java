package princeton.core.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import princeton.core.member.domain.entity.Member;
import princeton.core.member.repository.MemberRepository;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
