package princeton.toy.member.dto;

import lombok.Getter;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.article.dto.ArticlesDto;
import princeton.toy.member.domain.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class MemberAndArticleDto {

    private String loginId;
    private String email;
    private LocalDateTime createdAt;
    private List<ArticleDto> articles;

    public MemberAndArticleDto(Member member, ArticlesDto articlesDto) {
        this.loginId = member.getLoginId();
        this.email = member.getEmail();
        this.createdAt = member.getCreatedAt();
        this.articles = articlesDto.getarticlesDto();
    }
}
