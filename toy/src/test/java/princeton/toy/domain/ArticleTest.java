package princeton.toy.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class ArticleTest {

    @Test
    @DisplayName("Article 엔티티 생성 테스트")
    public void create() throws Exception {
        //given
        Users user = Users.builder()
                .email("princeton@gmail.com")
                .nickname("princeton")
                .password("password")
                .createdAt(LocalDateTime.now())
                .articles(new ArrayList<>())
                .build();

        String title = "title";
        String content = "내용!";
        Users author = user;
        LocalDateTime createdAt = LocalDateTime.now();


        //when
        Article createArticle = Article.builder()
                .title(title)
                .content(content)
                .author(user)
                .createdAt(createdAt)
                .comments(new ArrayList<>())
                .build();

        //then
        assertThat(createArticle.getTitle()).isEqualTo(title);
        assertThat(createArticle.getContent()).isEqualTo(content);
        assertThat(createArticle.getAuthor()).isEqualTo(author);
        assertThat(createArticle.getCreatedAt()).isEqualTo(createdAt);
        assertThat(createArticle.getComments()).isEmpty();
    }

}