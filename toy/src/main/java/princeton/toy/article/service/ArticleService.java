package princeton.toy.article.service;

import princeton.toy.article.domain.entity.Article;
import princeton.toy.member.domain.entity.Member;

import java.util.List;

public interface ArticleService {

    Long registration(Article article);

    List<Article> findMemberArticles(Member member);

    Article findArticleById(Long id);

    List<Article> findArticles();
}
