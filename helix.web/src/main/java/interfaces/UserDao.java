package interfaces;

import daoErrors.DAOException;
import model.User;

public interface UserDao {
    void persistUser(User user,String type) throws DAOException;
    User uploadUser(String login) throws DAOException;
}