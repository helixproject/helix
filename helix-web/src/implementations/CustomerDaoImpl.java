package implementations;


import interfaces.CustomerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import daoErrors.DAOException;
import model.Admin;
import model.Customer;
import model.User;

public class CustomerDaoImpl implements CustomerDao {
	private DAOFactory daoFactory;
	public CustomerDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	@Override
	public void persistCustomer(Customer customer) throws DAOException {
		new UserDaoImpl(daoFactory).persistUser(customer,"customer");
	}

	@Override
	public User uploadCustomer(String login) throws DAOException {
		
		return null;
	}


	
}