package princeton.toy.comment.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.comment.domain.entity.Comment;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public Long save(Comment comment) {
        em.persist(comment);
        return comment.getId();
    }

    public List<Comment> findByArticle(Article article) {
        return em.createQuery("select c from Comment c where c.author= :author", Comment.class)
                .setParameter("author", article)
                .getResultList();
    }
}
