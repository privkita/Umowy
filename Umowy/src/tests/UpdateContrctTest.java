package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dao.ContractDao;
import entities.Contract;

class UpdateContrctTest {

	@Test
	final void testUpdateContract() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Umowy");
		EntityManager em = emf.createEntityManager();
		ContractDao contractDao = new ContractDao(em);
		Contract contract = contractDao.getContractById("1/2018");
		LocalDate dateExp = LocalDate.parse("1410-07-15");
		contract.setStartDate(dateExp);
		
		contractDao.updateContract(contract);
		
		assertEquals(dateExp, contract.getStartDate());
		assertTrue(true);
	}

}
