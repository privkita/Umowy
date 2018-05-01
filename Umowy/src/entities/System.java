package entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity of System type element
 * @author Lucas Kita
 *
 */
@Entity
@Table(name="system")
public class System implements Serializable{
	
	@Id
	private String name;
	private String description;
	private String technologies;
	private String client;
	
	/**
	 * Returns name of the System
	 * @return name of the System
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setts the name of the System
	 * @param name System's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns description about System
	 * @return string containing description about System
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Setts description about System
	 * @param string containing description information about System
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns list and description of used technologies to build the System
	 * @return string containing list and descriptions of used technologies
	 */
	public String getTechnologies() {
		return technologies;
	}
	
	/**
	 * Setts information about used technologies to build the System
	 * @param technologies string containing information about used technologies
	 */
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	
	/**
	 * Returns System owner's name
	 * @return System owner's name
	 */
	public String getClient() {
		return client;
	}
	
	/**
	 * Setts System owner's name
	 * @param client name of System owner
	 */
	public void setClient(String client) {
		this.client = client;
	}
	

}
