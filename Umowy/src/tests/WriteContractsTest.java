package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dao.ContractDao;
import dao.XLSHandler;
import entities.Contract;

class WriteContractsTest {

	@Test
	final void testWriteContracts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Umowy");
		EntityManager em = emf.createEntityManager();
		String filePath = System.getProperty("user.dir") + ("/src/tests/test.xls");
		XLSHandler handler = new XLSHandler();
		List<Contract> list = new ArrayList<Contract>();
		ContractDao contractDao = new ContractDao(em);
		
		try {
			list = handler.loadFile(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		contractDao.writeContracts(list);
		Contract contract = contractDao.getContractById(list.get(0).getId());
		
		
		assertEquals(contract.getId(), list.get(0).getId());
		assertEquals(contract.getSystem(), list.get(0).getSystem());
		assertEquals(contract.getStartDate(), list.get(0).getStartDate());
		assertEquals(contract.getActive(), list.get(0).getActive());
	}

}
