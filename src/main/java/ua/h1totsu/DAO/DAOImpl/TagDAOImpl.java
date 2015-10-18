package ua.h1totsu.DAO.DAOImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import ua.h1totsu.DAO.TagDAO;
import ua.h1totsu.entity.Tag;
import ua.h1totsu.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class TagDAOImpl implements TagDAO {
    @Override
    public List<Tag> getAllTags() {
        Session session = null;
        List<Tag> tags = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tags = session.createCriteria(Tag.class).list();
        } catch (Exception e) {
            System.out.println("Error getAllTags(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return tags;
    }

    @Override
    public Tag getTag(String tag) {
        Session session = null;
        Tag tagObj = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Tag WHERE tag='" + tag + "'");
            tagObj = (Tag) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("Error getTag(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return tagObj;
    }

    @Override
    public void insertTag(Tag tag) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tag);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error insertTag(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void updateTag(Tag tag) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tag);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error updateTag(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void deleteTag(Tag tag) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(tag);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error deleteTag(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }
}
