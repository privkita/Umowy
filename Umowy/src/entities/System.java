package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="system")
public class System implements Serializable{
	
	@Id
	private String name;
	private String description;
	private String technologies;
	private String client;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	

}
