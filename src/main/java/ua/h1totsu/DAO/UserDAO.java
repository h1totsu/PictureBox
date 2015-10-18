package ua.h1totsu.DAO;

import ua.h1totsu.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserById(int userId);
    User getUserByLogin(String login);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    Integer validate(String login, String password);
}
