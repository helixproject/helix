package daoImpl;

import interfaces.PortMapperDao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.PortMapper;

public class PortMapperDaoImpl implements PortMapperDao{
	private static final int initPort=9999;
	private EntityManager em;
	public PortMapperDaoImpl(DatabaseConnection dbc){
		em=dbc.getEm();
	}

	public int getMaxPort() {
		Query query = em.createQuery("Select max(p.externalPort) from PortMapper p");
		Integer maxx;
		try{
			maxx= (Integer) query.getSingleResult();
			return maxx.intValue();
		}
		catch(Exception e){
			return initPort;
		}
	}

	public void persistPortMapper(PortMapper portmapper) {
		em.getTransaction().begin();
		em.persist(portmapper);
		em.getTransaction().commit();
	}
}