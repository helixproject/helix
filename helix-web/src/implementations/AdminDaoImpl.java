package implementations;


import interfaces.AdminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import daoErrors.DAOException;
import model.Admin;
import model.Customer;
import model.User;

public class AdminDaoImpl implements AdminDao {
	private DAOFactory daoFactory;
	public AdminDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	@Override
	public void persistAdmin(Admin admin) throws DAOException {
		// TODO Auto-generated method stub
		new UserDaoImpl(daoFactory).persistUser(admin,"admin");
	}
	@Override
	public Admin uploadAdmin(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	


	
}