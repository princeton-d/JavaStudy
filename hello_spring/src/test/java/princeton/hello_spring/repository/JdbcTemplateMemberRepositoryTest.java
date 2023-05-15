//package princeton.hello_spring.repository;
//
//import lombok.extern.slf4j.Slf4j;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import princeton.hello_spring.domain.Member;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@Slf4j
//@SpringBootTest
//@Transactional
//class JdbcTemplateMemberRepositoryTest {
//
//    @Autowired JdbcTemplateMemberRepository memberRepository;
//
//    @Test
//    public void save() throws Exception {
//        //given
//        Member member = new Member();
//        String name = "memberA";
//
//        //when
//        Member savedMember = memberRepository.save(member, name);
//
//        //then
//        assertThat(savedMember.getName()).isEqualTo(name);
//    }
//
//    @Test
//    public void findById() throws Exception {
//        //given
//        Member member = new Member();
//        String name = "memberA";
//        Member savedMember = memberRepository.save(member, name);
//        Long memberId = savedMember.getId();
//
//        //when
//        Member findMember = memberRepository.findById(memberId).get();
//        Optional<Member> emptyMember = memberRepository.findById(9999999L);
//
//        //then
//        assertThat(findMember.getName()).isEqualTo(name);
//        assertThat(emptyMember).isEqualTo(Optional.empty());
//    }
//
//    @Test
//    public void findByName() throws Exception {
//        //given
//        Member member = new Member();
//        String name = "memberA";
//        Member savedMember = memberRepository.save(member, name);
//        String memberName = savedMember.getName();
//
//        //when
//        Member findMember = memberRepository.findByName(memberName).get();
//        Optional<Member> emptyMember = memberRepository.findByName("emptyMemberName!!!");
//
//        //then
//        assertThat(findMember.getId()).isEqualTo(savedMember.getId());
//        assertThat(emptyMember).isEqualTo(Optional.empty());
//    }
//
//    @Test
//    public void findAll() throws Exception {
//        //given
//        int defaultMemberCount = memberRepository.findAll().size();
//
//        Member member1 = new Member();
//        String name1 = "memberA";
//        memberRepository.save(member1, name1);
//        Member member2 = new Member();
//        String name2 = "memberB";
//        memberRepository.save(member2, name2);
//
//        //when
//        List<Member> findMembers = memberRepository.findAll();
//
//        //then
//        assertThat(findMembers.size()).isEqualTo(2 + defaultMemberCount);
//    }
//
//}