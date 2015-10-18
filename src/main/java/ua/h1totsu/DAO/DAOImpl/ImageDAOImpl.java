package ua.h1totsu.DAO.DAOImpl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import ua.h1totsu.DAO.ImageDAO;
import ua.h1totsu.entity.Image;
import ua.h1totsu.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ImageDAOImpl implements ImageDAO {
    @Override
    public List<Image> getAllImages() {
        Session session = null;
        List<Image> images = new ArrayList<Image>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            images = session.createCriteria(Image.class).list();
        } catch (Exception e) {
            System.out.println("Error getAllImages(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return images;
    }

    @Override
    public Image getImageById(int imageId) {
        Session session = null;
        Image image = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            image = session.get(Image.class, imageId);
        } catch (Exception e) {
            System.out.println("Error getImageById(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return image;
    }

    @Override
    public void insertImage(Image image) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(image);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error insertImage(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void updateImage(Image image) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(image);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error updateImage(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void deleteImage(Image image) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(image);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error deleteImage(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    public List<Image> getAnyImages(int offset, int count) {
        Session session = null;
        List<Image> images = new ArrayList<Image>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Image.class);
            criteria.setFirstResult(offset);
            criteria.setMaxResults(count);
            images = criteria.list();
        } catch (Exception e) {
            System.out.println("Error getAnyImages(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return images;
    }

    public int getImagesCount() {
        Session session = null;
        Long count = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Image.class);
            criteria.setProjection(Projections.rowCount());
            count = (Long) criteria.uniqueResult();
        } catch (Exception e) {
            System.out.println("Error getImagesCount(): " + e);
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return count != null ? count.intValue() : -1;
    }
}
