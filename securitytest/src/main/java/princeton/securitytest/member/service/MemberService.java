package princeton.securitytest.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import princeton.securitytest.member.domain.entity.Member;
import princeton.securitytest.member.repository.MemberRepository;

import java.util.Optional;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(Member member) {
        return memberRepository.save(member);
    }

    @Transactional
    public Member updateMember(Long id, Long value) {
        Member findMember = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("wrong member id"));
        findMember.updateTestValue(findMember.getTestValue() + value);

        return findMember;
    }

}
