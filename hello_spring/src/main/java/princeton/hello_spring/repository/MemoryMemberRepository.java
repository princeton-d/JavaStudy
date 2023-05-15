//package princeton.hello_spring.repository;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import princeton.hello_spring.domain.Member;
//import princeton.hello_spring.exception.AlreadyRegisteredException;
//
//import java.util.*;
//
//@Repository
//public class MemoryMemberRepository implements MemberRepository {
//
//    private static Map<Long, Member> store = new HashMap<>();
//    private Long sequence = 0L;
//
//    @Override
//    public Member save(Member member, String name) {
//        Member savedMember = Member.builder()
//                .id(++sequence)
//                .name(name)
//                .build();
//        store.put(savedMember.getId(), savedMember);
//
//        return savedMember;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return Optional.ofNullable(store.get(id));
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        return store.values()
//                .stream().filter(m -> m.getName().equals(name))
//                .findAny();
//
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    public void clearStore() {
//        store.clear();
//    }
//
//}
