package princeton.toy.article.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.member.domain.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final EntityManager em;

    public Long save(Article article) {
        em.persist(article);
        return article.getId();
    }

    public Article findById(Long id) {
        return em.find(Article.class, id);
    }

    public List<Article> findByMember(Member member) {
        return em.createQuery("select a from Article a where a.author= :author", Article.class)
                .setParameter("author", member)
                .getResultList();
    }

    public List<Article> findAll() {
        return em.createQuery("select a from Article a", Article.class)
                .getResultList();
    }
}
