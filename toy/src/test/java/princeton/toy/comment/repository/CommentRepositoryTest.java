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

}