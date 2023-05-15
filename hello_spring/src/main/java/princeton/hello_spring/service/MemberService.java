package princeton.hello_spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import princeton.hello_spring.domain.Member;
import princeton.hello_spring.exception.AlreadyRegisteredException;
//import princeton.hello_spring.repository.JdbcTemplateMemberRepository;
import princeton.hello_spring.repository.JpaMemberRepository;
//import princeton.hello_spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    //    private final MemoryMemberRepository memberRepository;
//    private final JdbcTemplateMemberRepository memberRepository;
    private final JpaMemberRepository memberRepository;

    @Transactional
    public Long join(Member member, String name) {
        validateDuplicateMember(name);
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
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
