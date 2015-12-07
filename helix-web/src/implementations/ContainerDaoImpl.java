package implementations;


import interfaces.ContainerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import daoErrors.DAOException;
import model.Container;

public class ContainerDaoImpl implements ContainerDao {
	private DAOFactory daoFactory;
	public ContainerDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	@Override
	public void persistContainer(Container container) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		 try {
		        connexion = daoFactory.getConnection();
		        preparedStatement = connexion.prepareStatement("insert into Containers(idContainer,name,ip,ram,cpu,status,login,image,port) values(?,?,?,?,?,?,?,?,?)");	        
		        preparedStatement.setString(1,container.getId());
		        preparedStatement.setString(2,container.getName());
		        preparedStatement.setString(3,container.getIp());
		        preparedStatement.setInt(4,container.getRam());
		        preparedStatement.setInt(5,container.getCpu());
		        preparedStatement.setString(6,container.getStatus());
		        preparedStatement.setString(7,container.getUser().getLogin());
		        preparedStatement.setString(8,container.getImage());
		        preparedStatement.setInt(9,container.getPort());
		        
		        int statut = preparedStatement.executeUpdate();
		       System.out.println("statut = "+statut);
		       
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        fermeturesSilencieuses(preparedStatement, connexion );
		    }
		
	}

	@Override
	public Container uploadContainer(int idContainer) throws DAOException {
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

	public List<Container> uploadAllContainer(String type) throws DAOException {
		
		return null;
	}


	
}