package implementations;


import interfaces.AdminDao;
import daoErrors.DAOException;
import model.Admin;

public class AdminDaoImpl implements AdminDao {
	private DAOFactory daoFactory;
	
	public AdminDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	public void persistAdmin(Admin admin) throws DAOException {
		new UserDaoImpl(daoFactory).persistUser(admin,"admin");
	}
	
	public Admin uploadAdmin(String login) throws DAOException {
		return null;
	}
}