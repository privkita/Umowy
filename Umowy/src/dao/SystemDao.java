package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.System;

/**
 * DAO class for entity System, contains methods for the communication with database
 * @author Lucas Kita
 *
 */
public class SystemDao {
	
	private EntityManager em;
	
	/**
	 * Public constructor with parameter sent from ServletRequestListener
	 * @param em EntityManager 
	 * @see dao.DBInitializer#requestInitialized(javax.servlet.ServletRequestEvent)
	 */
	public SystemDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Send request to database for all elements of the System type
	 * @return list of elements of the System type
	 */
	public List<System> getSystems() {
		List<System> systems = em.createQuery("SELECT s FROM System s").getResultList();
		return systems;
	}
	
	//Szuka w bazie systemu po jego nazwie
	/**
	 * Send request to database for single element of the System type that have specified name 
	 * @param name name of the System type element
	 * @return single element of the System type with specified name
	 */
	public System getSystemByName(String name) {
		System system = (System) em.createQuery("SELECT s FROM System s WHERE s.name = :name").
				setParameter("name", name).getSingleResult();
		return system;
	}
	
	/**
	 * Add new Entity System to database 
	 * @param system Entity System type to add to database
	 * @return true if update succeed false if not
	 */
	public boolean addSystem(System system) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(system);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
		
	}

}
