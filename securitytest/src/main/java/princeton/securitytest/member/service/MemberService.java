package princeton.securitytest.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    public Member updateMember(Long id, String value) throws InterruptedException {
        Member findMember = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("wrong member id"));
        Thread.sleep(1000);
        findMember.updateTestValue(value);

        return findMember;
    }

}
