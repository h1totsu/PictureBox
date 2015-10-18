package ua.h1totsu.DAO.DAOImpl;

import org.hibernate.Session;
import ua.h1totsu.DAO.FavoriteDAO;
import ua.h1totsu.entity.UserImagePK;
import ua.h1totsu.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class FavoriteDAOImpl implements FavoriteDAO {
    @Override
    public List<UserImagePK> getAllUserImage() {
        Session session = null;
        List<UserImagePK> userImagePKs = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            userImagePKs = session.createCriteria(UserImagePK.class).list();
        } catch (Exception e) {
            System.out.println("Error getAllUserImage(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return userImagePKs;
    }

    @Override
    public UserImagePK getUImageByImageId(int imageId) {
        Session session = null;
        UserImagePK userImagePK = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            userImagePK = (UserImagePK) session.load(UserImagePK.class, imageId);
        } catch (Exception e) {
            System.out.println("Error getUImageByImageId(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return userImagePK;
    }

    @Override
    public UserImagePK getUImageByUserId(int userId) {
        Session session = null;
        UserImagePK userImagePK = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            userImagePK = (UserImagePK) session.load(UserImagePK.class, userId);
        } catch (Exception e) {
            System.out.println("Error getUImageByUserId(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return userImagePK;
    }
}
