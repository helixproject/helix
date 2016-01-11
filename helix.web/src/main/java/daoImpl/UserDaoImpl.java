
package daoImpl;
import interfaces.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.User;

public class UserDaoImpl implements UserDao{
	private EntityManager em;
	public UserDaoImpl(DatabaseConnection dbc){
		em=dbc.getEm();
	}
	
	public void persistUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public User uploadUser(String login,String password) {
		//i have to hash it after..
		String hashedPassword=password;
		Query query = em.createQuery("Select user from User user where user.login =:login and user.hashedPassword =:hashedPassword");
		query.setParameter("login",login);
		query.setParameter("hashedPassword",hashedPassword);
		User user;
		try{
			user=(User) query.getSingleResult();
		}
		catch(Exception e){
			return null;
		}
		return user;
	}
	
	 public User uploadUser(String login) {
 		Query query = em.createQuery("Select user from User user where user.login =:login");
 		query.setParameter("login",login);
 		User user;
 		try{
 			user=(User) query.getSingleResult();
 		}
 		catch(Exception e){
 			return null;
 		}
 		return user;
 	}
	
	public boolean isUser(String login) {
		//i have to hash it after..
		Query query = em.createQuery("Select user from User user where user.login =:login");
		query.setParameter("login",login);
		User user;
		try{
			user=(User) query.getSingleResult();
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	public void modifyUser(User user){
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}

	public void removeUser(User user) {
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		
	}
   
}