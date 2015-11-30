package implementations;


import interfaces.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import daoErrors.DAOException;
import model.Admin;
import model.Customer;
import model.User;

public class UserDaoImpl implements UserDao {
	private DAOFactory daoFactory;
	public UserDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	@Override
	public void persistUser(User user, String type) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		 try {
		        connexion = daoFactory.getConnection();
		        if(type.equals("customer")){
		        	Customer customer=(Customer)user;
		        	preparedStatement = connexion.prepareStatement("insert into Users(login,hashedPassword,kindOfMembership,type) values(?,?,?,?)");	        
		        	preparedStatement.setString(1,customer.getLogin());
		        	preparedStatement.setString(2,customer.getHashedPassword());
		        	preparedStatement.setString(3,customer.getKindOfMembership());
		        	preparedStatement.setString(4,type);
		        	
		        }
		        else if(type.equals("admin")){
		        	Admin admin=(Admin)user; //it was not obligatory to cast but just for more clarity
		        	preparedStatement = connexion.prepareStatement("insert into Users(login,hashedPassword,type) values(?,?,?)");	        
		        	preparedStatement.setString(1,admin.getLogin());
		        	preparedStatement.setString(2,admin.getHashedPassword());
		        	preparedStatement.setString(3,type);
		        }
		        int statut = preparedStatement.executeUpdate();
		       System.out.println("statut = "+statut);
		       
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        fermeturesSilencieuses(preparedStatement, connexion );
		    }
		
	}


	@Override
	public User uploadUser(String login) throws DAOException {
		// TODO Auto-generated method stub
		return null;
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