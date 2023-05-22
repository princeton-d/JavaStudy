package princeton.toy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class CommentTest {

    @Test
    @DisplayName("Comment 생성 테스트")
    public void create() throws Exception {
        //given
        Users createUser = Users.builder().build();
        Article createArticle = Article.builder().build();

        String content = "댓글댓글~";
        LocalDateTime createdAt = LocalDateTime.now();
        Users author = createUser;
        Article article = createArticle;

        //when
        Comment createComment = Comment.builder()
                .content(content)
                .createdAt(createdAt)
                .author(author)
                .article(article)
                .build();

        //then
        assertThat(createComment.getId()).isNull();
        assertThat(createComment.getContent()).isEqualTo(content);
        assertThat(createComment.getCreatedAt()).isEqualTo(createdAt);
        assertThat(createComment.getAuthor()).isEqualTo(author);
        assertThat(createComment.getArticle()).isEqualTo(article);
    }

}