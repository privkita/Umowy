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

	// Pobiera wszystkie Contract'y z bazy
	public List<Contract> getAllContracts() {
		@SuppressWarnings("unchecked")
		List<Contract> allContracts = em.createQuery("SELECT c FROM Contract c").getResultList();
		return allContracts;
	}

	// Pobiera Contract'y z bazy które są aktywne
	@SuppressWarnings("unchecked")
	public List<Contract> getActiveContracts() {
		List<Contract> activeContracts = em.createQuery("SELECT c FROM Contract c WHERE c.active = 'tak'")
				.getResultList();
		return activeContracts;
	}

	// Pobiera pojedynczy Contract po numerze Id
	public Contract getContractById(String id) {
		Contract contract = (Contract) em.createQuery("SELECT c FROM Contract c WHERE c.id = :id")
				.setParameter("id", id).getSingleResult();
		return contract;
	}

	// Aktualizuje dane Contract'u zwraca prawdę jęśli operacja zakończy się sukcesem 
	// lub fałsz jeśli porażką
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
	
	// Dodaje nowy Contract do bazy zwraca prawdę jęśli operacja zakończy się sukcesem 
	// lub fałsz jeśli porażką
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
	
	// Sprawdza czy baza o podanym numerze id istnieje, zwraca prawdę jeśli tak
	// lub fałsz jeśli nie istnieje
	public boolean idExist(String id) {
		try {
			getContractById(id);
			;
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// Zapisuje przysłaną listę Contract'ów do bazy, zwraca liczbę dodanych
	// Contract'ów
	public int writeContracts(List<Contract> contractsList) {
		EntityTransaction et = em.getTransaction();
		int counter = 0;
		for (Contract c : contractsList) {
			// Sprawdza czy są w bazie umowy o takim samym id co przysłane
			// jeśli tak dodaje do id przysłanego Contractu "A"
			while (idExist(c.getId())) {
				String newId = c.getId() + "A";
				c.setId(newId);
			}
			try {
				et.begin();
				em.persist(c);
				et.commit();
				counter ++;
			} catch (Exception e) {
				e.printStackTrace();
				et.rollback();
			}
		}
		return counter;
	}
}
