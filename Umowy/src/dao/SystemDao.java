package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.System;

public class SystemDao {
	
	private EntityManager em;
	
	public SystemDao(EntityManager em) {
		this.em = em;
	}
	public List<System> getSystems() {
		List<System> systems = em.createQuery("SELECT s FROM System s").getResultList();
		return systems;
	}
	public System getSystemByName(String name) {
		System system = (System) em.createQuery("SELECT s FROM System s WHERE s.name = :name").
				setParameter("name", name).getSingleResult();
		return system;
	}
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
