package princeton.hello_spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import princeton.hello_spring.domain.Member;
import princeton.hello_spring.exception.AlreadyRegisteredException;
import princeton.hello_spring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member, String name) throws AlreadyRegisteredException {
        validateDuplicateMember(name);
        memberRepository.save(member, name);
        return member.getId();
    }

    private void validateDuplicateMember(String name) {
        memberRepository.findByName(name)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다. 이름: " + name);
                });
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOndMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
