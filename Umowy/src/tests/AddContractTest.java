package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dao.ContractDao;
import entities.Contract;

class AddContractTest {

	@Test
	final void testAddContract() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Umowy");
		EntityManager em = emf.createEntityManager();
		ContractDao contractDao = new ContractDao(em);
		Contract contract = new Contract();
		contract.setId("1/1410");
		contract.setSystem("Grunwald");
		contract.setStartDate(LocalDate.parse("1410-07-15"));
		contract.setEndDate(LocalDate.parse("1945-05-08"));
		contract.setAmount(new BigDecimal("258000000000"));
		contract.setTax("netto");
		contract.setSettlement("jednorazowo");
		contract.setActive("nie");
		
		contractDao.addContract(contract);
		Contract newContract = contractDao.getContractById("1/1410");
		
		assertEquals(contract.getId(), newContract.getId());
		assertEquals(contract.getSystem(), newContract.getSystem());
		assertEquals(contract.getStartDate(), newContract.getStartDate());
		assertEquals(contract.getEndDate(), newContract.getEndDate());
		assertEquals(contract.getAmount(), newContract.getAmount());
		assertEquals(contract.getTax(), newContract.getTax());
		assertEquals(contract.getSettlement(), newContract.getSettlement());
		assertEquals(contract.getActive(), newContract.getActive());


		
	}

}
