package ua.h1totsu.DAO.DAOImpl;

import org.hibernate.Session;
import ua.h1totsu.DAO.CommentDAO;
import ua.h1totsu.entity.Comment;
import ua.h1totsu.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {
    @Override
    public List<Comment> getAllComments() {
        Session session = null;
        List<Comment> comments = new ArrayList<Comment>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            comments = session.createCriteria(Comment.class).list();
        } catch (Exception e) {
            System.out.println("Error getAllComments(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return comments;
    }

    @Override
    public Comment getCommentById(int commentId) {
        Session session = null;
        Comment comment = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            comment = (Comment) session.load(Comment.class, commentId);
        } catch (Exception e) {
            System.out.println("Error getCommentById(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return comment;
    }

    @Override
    public void insertComment(Comment comment) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(comment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error insertComment(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void updateComment(Comment comment) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(comment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error updateComment(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void deleteComment(Comment comment) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(comment);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error insertComment(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }
}
