package ua.h1totsu.DAO.DAOImpl;

import ua.h1totsu.DAO.*;

public class FactoryDAO {
    private static CommentDAO commentDAO = null;
    private static ImageDAO imageDAO = null;
    private static TagDAO tagDAO = null;
    private static UserDAO userDAO = null;
    private static FavoriteDAO favoriteDAO = null;

    private static FactoryDAO instance = null;

    public static synchronized FactoryDAO getInstance() {
        if(instance == null) {
            instance = new FactoryDAO();
        }
        return instance;
    }

    public CommentDAO getCommentDAO() {
        if(commentDAO == null) {
            commentDAO = new CommentDAOImpl();
        }
        return commentDAO;
    }

    public ImageDAO getImageDAO() {
        if(imageDAO == null) {
            imageDAO = new ImageDAOImpl();
        }
        return imageDAO;
    }

    public TagDAO getTagDAO() {
        if(tagDAO == null) {
            tagDAO = new TagDAOImpl();
        }
        return tagDAO;
    }

    public UserDAO getUserDAO() {
        if(userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    public FavoriteDAO getUserImageDAO() {
        if(favoriteDAO == null) {
            favoriteDAO = new FavoriteDAOImpl();
        }
        return favoriteDAO;
    }
}
