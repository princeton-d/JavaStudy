package princeton.hello_spring.repository;

import princeton.hello_spring.domain.Member;
import princeton.hello_spring.exception.AlreadyRegisteredException;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member, String name) throws AlreadyRegisteredException;

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
