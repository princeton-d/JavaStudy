package princeton.toy.comment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.article.repository.ArticleRepository;
import princeton.toy.comment.domain.entity.Comment;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentRepositoryTest {

    @Autowired MemberRepository memberRepository;
    @Autowired ArticleRepository articleRepository;
    @Autowired CommentRepository commentRepository;

    @Test
    public void save() throws Exception {
        //given
        Member member = new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password");
        memberRepository.save(member);

        Article article = new Article(member, "title", "content", LocalDateTime.now());
        articleRepository.save(article);

        Comment comment = new Comment(article, "content", LocalDateTime.now());

        //when
        Long savedId = commentRepository.save(comment);

        //then
        assertThat(savedId).isEqualTo(comment.getId());
    }

    @Test
    public void findByArticle() throws Exception {
        //given
        Member memberA = new Member("princetonA", "princetonA@test.com", LocalDateTime.now(), "passwordA");
        memberRepository.save(memberA);

        Article articleA = new Article(memberA, "titleA", "contentA", LocalDateTime.now());
        Article articleB = new Article(memberA, "titleB", "contentB", LocalDateTime.now());
        articleRepository.save(articleA);
        articleRepository.save(articleB);

        commentRepository.save(new Comment(articleA, "contentA1", LocalDateTime.now()));
        commentRepository.save(new Comment(articleA, "contentA2", LocalDateTime.now()));
        commentRepository.save(new Comment(articleB, "contentB", LocalDateTime.now()));

        //when
        List<Comment> findArticleAComments = commentRepository.findByArticle(articleA);
        List<Comment> findArticleBComments = commentRepository.findByArticle(articleB);

        //then
        assertThat(findArticleAComments.size()).isEqualTo(2);
        assertThat(findArticleBComments.size()).isEqualTo(1);
    }

}