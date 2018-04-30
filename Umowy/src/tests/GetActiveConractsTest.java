package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dao.ContractDao;
import entities.Contract;

class GetActiveConractsTest {

	@Test
	final void testGetActiveContracts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Umowy");
		EntityManager em = emf.createEntityManager();
		ContractDao contractDao = new ContractDao(em);
		
		List<Contract> list = contractDao.getActiveContracts();
		
		for (Contract c : list) 
			assertEquals("tak", c.getActive());
	}

}
