package interfaces;

import daoErrors.DAOException;
import model.Admin;

public interface AdminDao {
    void persistAdmin(Admin admin) throws DAOException;
    Admin uploadAdmin(String login) throws DAOException;
}