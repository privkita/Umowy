package tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dao.ContractDao;

class IdExistTest {

	@Test
	final void testIdExist() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Umowy");
		EntityManager em = emf.createEntityManager();
		ContractDao contractDao = new ContractDao(em);
		
		contractDao.idExist("1/2018");
		
		assertTrue(true);
		
		contractDao.idExist("wrongId");
		
		assertFalse(false);
	}

}
