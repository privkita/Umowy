package dao;

import java.util.List;

import javax.persistence.EntityManager;

public class SystemDao {
	
	private EntityManager em;
	
	public SystemDao(EntityManager em) {
		this.em = em;
	}
	public List<System> getSystems() {
		List<System> systems = em.createQuery("SELECT s FROM System s").getResultList();
		return systems;
	}

}
