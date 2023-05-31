package princeton.toy.article.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import princeton.toy.comment.domain.entity.Comment;
import princeton.toy.member.domain.entity.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id @GeneratedValue
    @Column(name = "article_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments = new ArrayList<>();

    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Article(Member member, String title, String content, LocalDateTime createdAt) {
        this.author = member;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}
