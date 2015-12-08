package implementations;

import interfaces.CustomerDao;
import daoErrors.DAOException;
import model.Customer;
import model.User;

public class CustomerDaoImpl implements CustomerDao {
	private DAOFactory daoFactory;
	public CustomerDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	public void persistCustomer(Customer customer) throws DAOException {
		new UserDaoImpl(daoFactory).persistUser(customer,"customer");
	}

	public User uploadCustomer(String login) throws DAOException {
		return null;
	}
}