package tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import entities.System;
import dao.SystemDao;

class GetSystemByNameTest {

	@Test
	final void testGetSystemByName() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Umowy");
		EntityManager em = emf.createEntityManager();
		SystemDao systemDao = new SystemDao(em);
		String nameExp = "Umowy";
		String nameUnexp = "CEPiK";
		
		System system = systemDao.getSystemByName(nameExp);
		
		assertEquals(nameExp, system.getName());
		assertNotEquals(nameUnexp, system.getName());
	}

}
