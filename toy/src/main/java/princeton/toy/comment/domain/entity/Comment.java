package princeton.toy.comment.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import princeton.toy.article.domain.entity.Article;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article author;

    private String content;
    private LocalDateTime createdAt;

    public Comment(Article article, String content, LocalDateTime createdAt) {
        this.author = article;
        this.content = content;
        this.createdAt = createdAt;
    }
}
