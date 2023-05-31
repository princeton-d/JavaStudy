package princeton.toy.article.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ArticleRepositoryTest {

    @Autowired private MemberRepository memberRepository;
    @Autowired private ArticleRepository articleRepository;

    @Test
    public void save() throws Exception {
        //given
        Member member = new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password");
        memberRepository.save(member);

        Article article = new Article(member, "title", "content", LocalDateTime.now());

        //when
        Long savedId = articleRepository.save(article);

        //then
        assertThat(savedId).isEqualTo(article.getId());
    }

    @Test
    public void findById() throws Exception {
        //given
        Member member = new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password");
        memberRepository.save(member);

        Article article = new Article(member, "title", "content", LocalDateTime.now());
        Long savedId = articleRepository.save(article);

        //when
        Article findArticle = articleRepository.findById(savedId);

        //then
        assertThat(findArticle).isEqualTo(article);
    }

    @Test
    public void findByMember() throws Exception {
        //given
        Member memberA = new Member("princetonA", "princetonA@test.com", LocalDateTime.now(), "passwordA");
        Member memberB = new Member("princetonB", "princetonB@test.com", LocalDateTime.now(), "passwordB");
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        Article articleA1 = new Article(memberA, "title", "content", LocalDateTime.now());
        Article articleA2 = new Article(memberA, "title", "content", LocalDateTime.now());
        Article articleB1 = new Article(memberB, "title", "content", LocalDateTime.now());
        articleRepository.save(articleA1);
        articleRepository.save(articleA2);
        articleRepository.save(articleB1);

        //when
        List<Article> findArticles = articleRepository.findByMember(memberA);

        //then
        assertThat(findArticles.size()).isEqualTo(2);
    }

    @Test
    public void findEmptyArticles() throws Exception {
        //given
        Member memberA = new Member("princetonA", "princetonA@test.com", LocalDateTime.now(), "passwordA");
        Member memberB = new Member("princetonB", "princetonB@test.com", LocalDateTime.now(), "passwordB");
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        Article article = new Article(memberA, "title", "content", LocalDateTime.now());
        articleRepository.save(article);

        //when
        List<Article> findArticles = articleRepository.findByMember(memberB);

        //then
        assertThat(findArticles).isEmpty();
    }

    @Test
    public void findAll() throws Exception {
        //given
        Member memberA = new Member("princetonA", "princetonA@test.com", LocalDateTime.now(), "passwordA");
        Member memberB = new Member("princetonB", "princetonB@test.com", LocalDateTime.now(), "passwordB");
        memberRepository.save(memberA);
        memberRepository.save(memberB);

        Article articleA1 = new Article(memberA, "title", "content", LocalDateTime.now());
        Article articleA2 = new Article(memberA, "title", "content", LocalDateTime.now());
        Article articleB1 = new Article(memberB, "title", "content", LocalDateTime.now());
        articleRepository.save(articleA1);
        articleRepository.save(articleA2);
        articleRepository.save(articleB1);

        //when
        List<Article> findArticles = articleRepository.findAll();

        //then
        assertThat(findArticles.size()).isEqualTo(3);
    }

}