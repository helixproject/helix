package daoImpl;

import interfaces.PortMapperDao;
import interfaces.UserDao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.PortMapper;
import model.User;

public class PortMapperDaoImpl implements PortMapperDao{
	private static final int initPort=9999;
	private EntityManager em;
	public PortMapperDaoImpl(DatabaseConnection dbc){
		em=dbc.getEm();
	}

	public int getMaxPort() {
		Query query = em.createQuery("Select max(p.externalPort) from PortMapper p");
		int max=(Integer) query.getSingleResult();
		if(max==0)
			return initPort;
		return max;
	}

	public void persistPortMapper(PortMapper portmapper) {
		em.getTransaction().begin();
		em.persist(portmapper);
		em.getTransaction().commit();
	}
}