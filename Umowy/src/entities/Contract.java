package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity of Contract type element
 * @author Lucas Kita
 *
 */
@Entity
@Table(name = "contract")
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String system;
	private LocalDate startDate;
	private LocalDate endDate;
	private BigDecimal amount;
	private String settlement;
	private String active;
	private String tax;

	/**
	 * Returns the Contract id number
	 * @return id number of Contract
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setts the Contract id number
	 * @param id Contract's id number
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Returns the name of the System contained in the Contract 
	 * @return System name
	 */
	public String getSystem() {
		return system;
	}
	
	 /**
	  * Setts the name of the System contained in the Contract 
	  * @param System name of system contained in Contract
	  */
	public void setSystem(String system) {
		this.system = system;
	}
	
	/**
	 * Returns the date of start of the Contract
	 * @return starting date
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	
	/**
	 * Setts the starting date of the Contract
	 * @param startDate the date when Contract start
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	/**
	 *  Returns the date when the Contract ends
	 * @return ending date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	
	/**
	 * Setts the ending date of the Contract
	 * @param endDate the date when the Contract ends
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Returns the amount of the Contract
	 * @return amount of the Contract
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * Setts the amount of the Contract
	 * @param amount the amount of the Contract
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	/**
	 * Returns billing period of the Contract
	 * @return billing period of the Contract
	 */
	public String getSettlement() {
		return settlement;
	}
	
	/**
	 * Setts billing period of the Contract
	 * @param settlement billing period of the Contract
	 */
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}
	
	/**
	 * Returns whether the contract is active or not
	 * @return whether the contract is active or not
	 */
	public String getActive() {
		return active;
	}
	
	/**
	 * Setts whether the contract is active or not
	 * @param active whether the contract is active or not
	 */
	public void setActive(String active) {
		this.active = active;
	}
	
	/**
	 * Returns information whether the amount of Contract is with or without tax
	 * @return amount of Contract is with or without tax
	 */
	public String getTax() {
		return tax;
	}
	
	/**
	 * Setts the information whether the amount of Contract is with or without tax
	 * @param tax with or without tax
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}
}
