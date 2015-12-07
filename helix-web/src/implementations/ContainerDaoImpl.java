package implementations;


import interfaces.ContainerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Container;
import model.Customer;
import model.User;
import daoErrors.DAOException;

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
	public List<Container> uploadAllContainer(User user) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		List<Container> containers=new ArrayList<Container>();
		 try {
		        connexion = daoFactory.getConnection();
		        Customer customer=null;
		        Admin admin=null;
		        String type;
		        try{
		        	customer=(Customer)user;
		        	type="customer";
		        }
		        catch(Exception e){
		        	admin=(Admin)user;
		        	type="admin";
		        }
		        String selectSQL = null;
		        if(type.equals("customer")){
		        	selectSQL = "select * from Containers where login=?";
		        	preparedStatement = connexion.prepareStatement(selectSQL);
					preparedStatement.setString(1,user.getLogin());
		        	
		        }
		        else if(type.equals("admin")){
		        	selectSQL = "select * from Containers";
		        	preparedStatement = connexion.prepareStatement(selectSQL);
		        }
		        		
		        ResultSet rs = preparedStatement.executeQuery(selectSQL );
		        while (rs.next()) {
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
		        	User owner=new UserDaoImpl(daoFactory).uploadUser(login);		
		        	containers.add(new Container(id, name, cpu, ram, status, ip, image, port, owner));

		        }
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {    	
		        fermeturesSilencieuses(preparedStatement, connexion );
		        return containers;
		    }
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
		        return container;
		    }
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