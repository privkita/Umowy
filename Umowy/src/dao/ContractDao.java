package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Contract;

public class ContractDao {

	private EntityManager em;
	
	public ContractDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Contract> getAllContracts() {
		List<Contract> allContracts = em.createQuery("SELECT c FROM Contract c").getResultList();
		return allContracts;
	}
	
	public List<Contract> getActiveContracts() {
		List<Contract> activeContracts = 
				em.createQuery("SELECT c FROM Contract c WHERE c.active = 'tak'").getResultList();
		return activeContracts;
	}
	
	public Contract getContractById(String id) {
		Contract contract = (Contract) em.createQuery("SELECT c FROM Contract c WHERE c.id = :id").
				setParameter("id", id).getSingleResult();
		return contract;
	}
	
	public boolean updateContract(Contract contract) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.merge(contract);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}

	public boolean addContract(Contract contract) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(contract);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
	
	public boolean idExist(String id) {
		EntityTransaction et = em.getTransaction();
		try {
			em.createQuery("SELECT c FROM Contract c WHERE c.id = :id").
				setParameter("id", id).getSingleResult();
			return true;
		} catch (Exception e) {
		return false;
		}
	}

	public void writeContracts(List<Contract> contractsList) {
		EntityTransaction et = em.getTransaction();
		for (Contract c : contractsList) {
			// Sprawdza czy są w bazie umowy o takim samym id jeśli tak dodaje do id "A"
			while (idExist(c.getId())) {
				String newId = c.getId() + "A";
				c.setId(newId);
			}			
			try {
				et.begin();
				em.persist(c);
				et.commit();
			} catch (Exception e) {
				e.printStackTrace();
				et.rollback();
			}
		}
	}
}
