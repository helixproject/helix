package interfaces;

import daoErrors.DAOException;
import model.Customer;
import model.User;

public interface CustomerDao {
    void persistCustomer(Customer customer) throws DAOException;
    User uploadCustomer(String login) throws DAOException;
}