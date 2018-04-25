package dao;

import java.util.List;

import javax.persistence.EntityManager;

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
}
