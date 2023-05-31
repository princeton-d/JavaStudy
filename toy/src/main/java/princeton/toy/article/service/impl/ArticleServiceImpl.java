package princeton.toy.article.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.article.repository.ArticleRepository;
import princeton.toy.article.service.ArticleService;
import princeton.toy.member.domain.entity.Member;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Long registration(Article article) {
        Long savedId = articleRepository.save(article);
        return savedId;
    }

    @Override
    public List<Article> findMemberArticles(Member member) {
        List<Article> findArticles = articleRepository.findByMember(member);
        return findArticles;
    }

    @Override
    public Article findArticleById(Long id) {
        Article findArticle = articleRepository.findById(id);
        return findArticle;
    }

    @Override
    public List<Article> findArticles() {
        List<Article> findArticles = articleRepository.findAll();
        return findArticles;
    }
}
