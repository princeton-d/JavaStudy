package princeton.toy.member.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import princeton.toy.article.domain.domain.Article;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String loginId;
    private String email;
    private LocalDateTime createdAt;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

    public Member(String loginId, String email, LocalDateTime createdAt, String password) {
        this.loginId = loginId;
        this.email = email;
        this.createdAt = createdAt;
        this.password = password;
    }
}
