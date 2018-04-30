package tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dao.SystemDao;
import entities.System;

class AddSystemTest {

	@Test
	final void testAddSystem() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Umowy");
		EntityManager em = emf.createEntityManager();
		SystemDao systemDao = new SystemDao(em);
		System system = new System();
		system.setName("Grunwald");
		system.setDescription("System niszczący intruzów - antywirus");
		system.setTechnologies("Łuki, miecze i topory");
		system.setClient("Jagiełło");
		
		systemDao.addSystem(system);
		System newSystem = systemDao.getSystemByName("Grunwald");
		
		assertEquals(system.getName(), newSystem.getName());
		assertEquals(system.getDescription(), newSystem.getDescription());
		assertEquals(system.getTechnologies(), newSystem.getTechnologies());
		assertEquals(system.getClient(), newSystem.getClient());
		assertNotEquals("Umowy", newSystem.getName());
		
		
		
		
	}

}
