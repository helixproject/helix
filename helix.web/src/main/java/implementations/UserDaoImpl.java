package implementations;

import interfaces.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import daoErrors.DAOException;
import model.Admin;
import model.Container;
import model.Customer;
import model.User;

public class UserDaoImpl implements UserDao {
	private DAOFactory daoFactory;
	public UserDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	public void persistUser(User user, String role) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		 try {
		        connexion = daoFactory.getConnection();
		        if(role.equals("customer")){
		        	Customer customer=(Customer)user;
		        	preparedStatement = connexion.prepareStatement("insert into Users(login,hashedPassword,type,role) values(?,?,?,?)");	        
		        	preparedStatement.setString(1,customer.getLogin());
		        	preparedStatement.setString(2,customer.getHashedPassword());
		        	preparedStatement.setString(3,customer.getType());
		        	preparedStatement.setString(4,role);
		        	
		        }
		        else if(role.equals("admin")){
		        	Admin admin=(Admin)user; //it was not obligatory to cast but just for more clarity
		        	preparedStatement = connexion.prepareStatement("insert into Users(login,hashedPassword,role) values(?,?,?)");	        
		        	preparedStatement.setString(1,admin.getLogin());
		        	preparedStatement.setString(2,admin.getHashedPassword());
		        	preparedStatement.setString(3,role);
		        }
		        int statut = preparedStatement.executeUpdate();
		       // System.out.println("statut = "+statut);
		       
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        fermeturesSilencieuses(preparedStatement, connexion);
		    }
	}

	public User uploadUser(String login) throws DAOException {
		return new Customer("customer","7c2ab87a34395892f10413db233c6420","gold");
	}
	
	public User getUserByLogin(String login){
		
		User user_returned = null ;
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = daoFactory.getConnection();
			String selectSQL = "select * from Users where login = \""+login+"\" ;";	
			preparedStatement = connexion.prepareStatement(selectSQL);
	        ResultSet rs = preparedStatement.executeQuery(selectSQL);
	        
	        while (rs.next()) {
	        	int idUser = rs.getInt("idUser");
	        	String hashedPassword = rs.getString("hashedPassword");
	        	String type = rs.getString("type");
	        	String role = rs.getString("role");
	        	if(role.equals("customer")){
	        		user_returned = new Customer(login, hashedPassword, type);
	        	}
	        	else {
	        		user_returned = new Admin(login, hashedPassword);
	        	}
        		user_returned.setIdUser(idUser);
	        }
		 }
		 catch (SQLException e) {
			 throw new DAOException(e);
		    } finally {
		    	fermeturesSilencieuses(preparedStatement, connexion);
		    	}
		return user_returned ;
	}
	   
	/* Fermeture silencieuse du resultset */
	public static void fermetureSilencieuse( ResultSet resultSet ) {
	    if ( resultSet != null ) {
	        try {
	            resultSet.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
	        }
	    }
	}

	/* Fermeture silencieuse du statement */
	public static void fermetureSilencieuse( Statement statement ) {
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
	        }
	    }
	}

	/* Fermeture silencieuse de la connexion */
	public static void fermetureSilencieuse( Connection connexion ) {
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
	        }
	    }
	}

	/* Fermetures silencieuses du statement et de la connexion */
	public static void fermeturesSilencieuses( Statement statement, Connection connexion ) {
	    fermetureSilencieuse( statement );
	    fermetureSilencieuse( connexion );
	}

	/* Fermetures silencieuses du resultset, du statement et de la connexion */
	public static void fermeturesSilencieuses( ResultSet resultSet, Statement statement, Connection connexion ) {
	    fermetureSilencieuse( resultSet );
	    fermetureSilencieuse( statement );
	    fermetureSilencieuse( connexion );
	}
}