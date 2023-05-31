package princeton.toy.comment.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import princeton.toy.comment.domain.entity.Comment;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public Long save(Comment comment) {
        em.persist(comment);
        return comment.getId();
    }
}
