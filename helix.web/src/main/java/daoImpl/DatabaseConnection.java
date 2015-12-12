package daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnection{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public DatabaseConnection(){
		emf = Persistence.createEntityManagerFactory("example");
		setEm(emf.createEntityManager());
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}