package princeton.toy.article.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.service.MemberService;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ArticleServiceTest {

    @Autowired MemberService memberService;
    @Autowired ArticleService articleService;
    
    @Test
    public void registration() throws Exception {
        //given
        Long savedMemberId = memberService.join(new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password"));
        Member member = memberService.findMemberById(savedMemberId);

        Article article = new Article(member, "title", "content", LocalDateTime.now());

        //when
        Long savedArticleId = articleService.registration(article);
        
        //then
        assertThat(savedArticleId).isEqualTo(article.getId());
    }

    @Test
    public void findMemberArticles() throws Exception {
        //given
        Long memberAId = memberService.join(new Member("princetonA", "princetonA@test.com", LocalDateTime.now(), "passwordA"));
        Member memberA = memberService.findMemberById(memberAId);
        Article articleA1 = new Article(memberA, "titleA1", "contentA1", LocalDateTime.now());
        Article articleA2 = new Article(memberA, "titleA2", "contentA2", LocalDateTime.now());
        articleService.registration(articleA1);
        articleService.registration(articleA2);

        Long memberBId = memberService.join(new Member("princetonB", "princetonB@test.com", LocalDateTime.now(), "passwordB"));
        Member memberB = memberService.findMemberById(memberBId);
        Article articleB1 = new Article(memberB, "titleB1", "contentB1", LocalDateTime.now());
        articleService.registration(articleB1);

        //when
        List<Article> findMemberAArticles = articleService.findMemberArticles(memberA);
        List<Article> findMemberBArticles = articleService.findMemberArticles(memberB);

        //then
        assertThat(findMemberAArticles.size()).isEqualTo(2);
        assertThat(findMemberBArticles.size()).isEqualTo(1);
    }

    @Test
    public void findArticleById() throws Exception {
        //given
        Long savedMemberId = memberService.join(new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password"));
        Member member = memberService.findMemberById(savedMemberId);

        Article article = new Article(member, "title", "content", LocalDateTime.now());
        Long savedArticleId = articleService.registration(article);

        //when
        Article findArticle = articleService.findArticleById(savedArticleId);

        //then
        assertThat(findArticle.getId()).isEqualTo(savedArticleId);
    }

    @Test
    public void findArticles() throws Exception {
        //given
        Long memberAId = memberService.join(new Member("princetonA", "princetonA@test.com", LocalDateTime.now(), "passwordA"));
        Member memberA = memberService.findMemberById(memberAId);
        Article articleA1 = new Article(memberA, "titleA1", "contentA1", LocalDateTime.now());
        Article articleA2 = new Article(memberA, "titleA2", "contentA2", LocalDateTime.now());
        articleService.registration(articleA1);
        articleService.registration(articleA2);

        Long memberBId = memberService.join(new Member("princetonB", "princetonB@test.com", LocalDateTime.now(), "passwordB"));
        Member memberB = memberService.findMemberById(memberBId);
        Article articleB1 = new Article(memberB, "titleB1", "contentB1", LocalDateTime.now());
        articleService.registration(articleB1);

        //when
        List<Article> findArticles = articleService.findArticles();

        //then
        assertThat(findArticles.size()).isEqualTo(3);
    }

}