package daoImpl;

import interfaces.ContainerDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Container;
import model.Customer;


public class ContainerDaoImpl implements ContainerDao {
	private EntityManager em;
	public ContainerDaoImpl(DatabaseConnection dbc){
		em=dbc.getEm();
	}
	
	public void persistContainer(Container container) {
		em.getTransaction().begin();
		em.persist(container);
		em.getTransaction().commit();
	}

	public Container uploadContainer(String idDocker) {
		Query query = em.createQuery("Select container from Container container where container.idDocker =:idDocker");
		query.setParameter("idDocker",idDocker);
		Container container;
		container=(Container) query.getSingleResult();
		return container;
	}
	
	public String getContainerName(String idDocker) {
		Query query = em.createQuery("Select container.name from Container container where container.idDocker =:idDocker");
		query.setParameter("idDocker",idDocker);
		String name = (String) query.getSingleResult();
		return name;
	}
	
	public List<Container> uploadAllContainer() {
		List<Container> containers;
		Query query = em.createQuery("Select container from Container container");
		containers=query.getResultList();
		return containers;
	}
	
	public void modifyContainer(Container container) {
		em.getTransaction().begin();
		em.merge(container);
		em.getTransaction().commit();
		
	}

	public List<Container> uploadAllContainerOfUser(Customer customer) {
		List<Container> containers;
		Query query = em.createQuery("Select container from Container container where container.owner = :owner");
		query.setParameter("owner",customer);
		containers=query.getResultList();
		return containers;
	}

	public void removeContainer(Container container) {
		em.getTransaction().begin();
		em.remove(container);
		em.getTransaction().commit();
		
	}   
}
