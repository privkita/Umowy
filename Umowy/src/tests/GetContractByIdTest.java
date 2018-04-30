package tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dao.ContractDao;
import entities.Contract;

class GetContractByIdTest {

	@Test
	final void testGetContractById() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Umowy");
		EntityManager em = emf.createEntityManager();
		ContractDao contractDao = new ContractDao(em);
		String idExp = "1/2018";
		String sysExp = "Umowy";
		String idUnexp = "1/2017";
		
		Contract contract = contractDao.getContractById(idExp);
		
		assertEquals(idExp, contract.getId());
		assertEquals(sysExp, contract.getSystem());
		assertNotEquals(idUnexp, contract.getId());
	}

}
