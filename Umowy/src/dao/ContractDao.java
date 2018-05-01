package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Contract;

/**
 * DAO class for entity Contract, contains methods for the communication with database
 * @author Lucas Kita
 *
 */

public class ContractDao {
	
	private EntityManager em;
	
	/**
	 * Public constructor with parameter sent from ServletRequestListener
	 * @param em EntityManager 
	 * @see dao.DBInitializer#requestInitialized(javax.servlet.ServletRequestEvent)
	 */
	public ContractDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * Send request to database for all elements of the Contract type
	 * @return list of elements of the Contract type
	 */
	public List<Contract> getAllContracts() {
		@SuppressWarnings("unchecked")
		List<Contract> allContracts = em.createQuery("SELECT c FROM Contract c").getResultList();
		return allContracts;
	}
	
	/**
	 * Send request to database for all elements of the Contract type that have element "active"
	 * set on yes
	 * @return list of elements of the Contract type with specified element "active" on yes 
	 */
	@SuppressWarnings("unchecked")
	public List<Contract> getActiveContracts() {
		List<Contract> activeContracts = em.createQuery("SELECT c FROM Contract c WHERE c.active = 'tak'")
				.getResultList();
		return activeContracts;
	}
	
	/**
	 * Send request to database for single element of the Contract type that have specified id 
	 * @param id identification number of element of the Contract type
	 * @return single element of the Contract type with specified id
	 */
	public Contract getContractById(String id) {
		Contract contract = (Contract) em.createQuery("SELECT c FROM Contract c WHERE c.id = :id")
				.setParameter("id", id).getSingleResult();
		return contract;
	}

	/**
	 * Update parameters of Entity Contract in database
	 * @param contract Entity Contract type to update in database
	 * @return true if update succeed false if not
	 */
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
	
	/**
	 * Add new Entity Contract to database 
	 * @param contract Entity Contract type to add to database
	 * @return true if update succeed false if not
	 */
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
	
	/**
	 * Search for Contract with specified id in database
	 * @param id parameter of Contract type element 
	 * @return true if Contract with parameter id exist, false if not
	 */
	public boolean idExist(String id) {
		try {
			getContractById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Add list of Contract type elements to database. Checks Contract id, if exist adds a char 
	 * to get a unique id number of added Contract
	 * @param contractsList list of Contract type elements to add to database
	 * @return number of added Contracts to database
	 */
	public int writeContracts(List<Contract> contractsList) {
		EntityTransaction et = em.getTransaction();
		int writeNumber = 0;
		for (Contract c : contractsList) {
			while (idExist(c.getId())) {
				String newId = c.getId() + "A";
				c.setId(newId);
			}
			try {
				et.begin();
				em.persist(c);
				et.commit();
				writeNumber ++;
			} catch (Exception e) {
				e.printStackTrace();
				et.rollback();
			}
		}
		return writeNumber;
	}
}
