package princeton.toy.article.domain.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import princeton.toy.comment.domain.domain.Comment;
import princeton.toy.member.domain.entity.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id @GeneratedValue
    @Column(name = "article_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Article(Member member, String title, String content, LocalDateTime createdAt) {
        this.member = member;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}
