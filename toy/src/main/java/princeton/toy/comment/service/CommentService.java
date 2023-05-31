package princeton.toy.comment.service;

import princeton.toy.article.domain.entity.Article;
import princeton.toy.comment.domain.entity.Comment;

import java.util.List;

public interface CommentService {
    Long registration(Comment comment);

    List<Comment> findCommentByArticle(Article article);
}
