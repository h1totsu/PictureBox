package ua.h1totsu.DAO.DAOImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import ua.h1totsu.DAO.UserDAO;
import ua.h1totsu.entity.User;
import ua.h1totsu.persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAllUsers() {
        Session session = null;
        List<User> users = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (Exception e) {
            System.out.println("Error getUserById(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return users;
    }

    @Override
    public User getUserById(int userId) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = session.get(User.class, userId);
        } catch (Exception e) {
            System.out.println("Error getUserById(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM User WHERE login='" + login + "'");
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            System.out.println("Error getUserByLogin(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
        return user;
    }

    @Override
    public void insertUser(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error insertUser(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void updateUser(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error updateUser(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public void deleteUser(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error deleteUser(): " + e);
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    public Integer validate(String login, String password) {
        User user = FactoryDAO.getInstance().getUserDAO().getUserByLogin(login);
        if(user == null) return null;
        else if(user.getLogin().equals(login) &&
                user.getPassword().equals(password))
            return user.getUserId();
        return null;
    }
}
