package implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Refreshable;

import daoErrors.DAOException;
import interfaces.ContainerDao;
import model.Container;
import model.User;

public class ContainerDaoImpl implements ContainerDao {
	private DAOFactory daoFactory;
	public ContainerDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	public void persistContainer(Container container) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		 try {
		        connexion = daoFactory.getConnection();
		        preparedStatement = connexion.prepareStatement("insert into Containers(idContainer,name,ip,ram,cpu,status,port, idUser) values(?,?,?,?,?,?,?,?)");	        
		        preparedStatement.setString(1,container.getId());
		        preparedStatement.setString(2,container.getName());
		        preparedStatement.setString(3,container.getIp());
		        preparedStatement.setInt(4,container.getRam());
		        preparedStatement.setInt(5,container.getCpu());
		        preparedStatement.setString(6,container.getStatus());
		        preparedStatement.setInt(7,container.getPort());
		        // this line should be properly written
		        preparedStatement.setInt(8,2);
		        
		        int statut = preparedStatement.executeUpdate();
		        System.out.println("status = "+statut);
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        fermeturesSilencieuses(preparedStatement, connexion );
		    }
	}
	
	public List<Container> uploadAllContainer(User user) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		List<Container> containers=new ArrayList<Container>();
		
		 try {
		        connexion = daoFactory.getConnection();
		        String selectSQL = null;
		        // if user is customer
		        if(user.getRole().equals("Customer")){
		        	
		        	//selectSQL = "select * from Containers where login = ?";
					//preparedStatement.setString(1,"\""+user.getLogin()+"\"");
		        	
		        	// sth not working here, I just changed it to simple sql
		        	selectSQL = "select * from Containers where idUser = \""+user.getIdUser()+"\" ; ";
		        	preparedStatement = connexion.prepareStatement(selectSQL);
		        }
		        // if user is admin
		        else {
		        	selectSQL = "select * from Containers";
		        	preparedStatement = connexion.prepareStatement(selectSQL);
		        }
		        		
		        ResultSet rs = preparedStatement.executeQuery(selectSQL);
		        
		        while (rs.next()) {
		        	String id=rs.getString("idContainer");
		        	int cpu=rs.getInt("cpu");
		        	int ram=rs.getInt("ram");
		        	String status=rs.getString("status");
		        	String ip=rs.getString("ip");
		        	String idImage=rs.getString("idImage");
		        	int port=rs.getInt("port");
		        	String name=rs.getString("name");
		        	String idUser=rs.getString("idUser");
		        	
		        	//have to implement following
		        	//User owner = new UserDaoImpl(daoFactory).uploadUser(idUser);		
		        	containers.add(new Container(id, name, cpu, ram, status, ip, idImage, port, user));
		        }
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } 
		 	finally {    	
		        fermeturesSilencieuses(preparedStatement, connexion);
		    }
		return containers;
	}
	
	public Container uploadContainer(int idContainer) throws DAOException {
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		Container container=null;
		 try {
		        connexion = daoFactory.getConnection();		     	        
		        String selectSQL = "select * from Containers where idContainer=?";
				preparedStatement = connexion.prepareStatement(selectSQL);
				preparedStatement.setInt(1,idContainer);
				ResultSet rs = preparedStatement.executeQuery(selectSQL );
				if (rs.next()) {
					String id=rs.getString("idContainer");
					int cpu=rs.getInt("cpu");
					int ram=rs.getInt("ram");
					String status=rs.getString("status");
					String ip=rs.getString("ip");
					String image=rs.getString("image");
					int port=rs.getInt("port");
					String name=rs.getString("name");
					String login=rs.getString("login");
					
					//have to implement following
					User user=new UserDaoImpl(daoFactory).uploadUser(login);
					
					container=new Container(id, name, cpu, ram, status, ip, image, port, user);
				}
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {    	
		        fermeturesSilencieuses(preparedStatement, connexion );
		    }
	        return container;
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