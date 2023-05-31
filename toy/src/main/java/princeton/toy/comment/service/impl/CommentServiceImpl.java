package princeton.toy.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import princeton.toy.article.domain.entity.Article;
import princeton.toy.comment.domain.entity.Comment;
import princeton.toy.comment.repository.CommentRepository;
import princeton.toy.comment.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Long registration(Comment comment) {
        Long savedId = commentRepository.save(comment);
        return savedId;
    }

    @Override
    public List<Comment> findCommentByArticle(Article article) {
        List<Comment> findComments = commentRepository.findByArticle(article);
        return findComments;
    }
}
