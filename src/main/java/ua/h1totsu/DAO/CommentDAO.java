package ua.h1totsu.DAO;

import ua.h1totsu.entity.Comment;

import java.util.List;

public interface CommentDAO {
    List<Comment> getAllComments();
    Comment getCommentById(int commentId);
    void insertComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(Comment comment);
}
