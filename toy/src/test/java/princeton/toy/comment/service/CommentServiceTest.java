package princeton.toy.comment.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.article.service.ArticleService;
import princeton.toy.comment.domain.entity.Comment;
import princeton.toy.member.domain.entity.Member;
import princeton.toy.member.service.MemberService;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentServiceTest {

    @Autowired MemberService memberService;
    @Autowired ArticleService articleService;
    @Autowired CommentService commentService;
    
    @Test
    public void registration() throws Exception {
        //given
        Member member = new Member("princeton", "princeton@test.com", LocalDateTime.now(), "password");
        memberService.join(member);

        Article article = new Article(member, "title", "content", LocalDateTime.now());
        articleService.registration(article);

        Comment comment = new Comment(article, "content", LocalDateTime.now());

        //when
        Long savedId = commentService.registration(comment);
        
        //then
        assertThat(savedId).isEqualTo(comment.getId());
    }

    @Test
    public void findCommentByArticle() throws Exception {
        //given
        Member memberA = new Member("princetonA", "princetonA@test.com", LocalDateTime.now(), "passwordA");
        memberService.join(memberA);

        Article articleA = new Article(memberA, "titleA", "contentA", LocalDateTime.now());
        Article articleB = new Article(memberA, "titleB", "contentB", LocalDateTime.now());
        articleService.registration(articleA);
        articleService.registration(articleB);

        commentService.registration(new Comment(articleA, "contentA1", LocalDateTime.now()));
        commentService.registration(new Comment(articleA, "contentA2", LocalDateTime.now()));
        commentService.registration(new Comment(articleB, "contentB", LocalDateTime.now()));

        //when
        List<Comment> findArticleAComments = commentService.findCommentByArticle(articleA);
        List<Comment> findArticleBComments = commentService.findCommentByArticle(articleB);

        //then
        assertThat(findArticleAComments.size()).isEqualTo(2);
        assertThat(findArticleBComments.size()).isEqualTo(1);
    }

}