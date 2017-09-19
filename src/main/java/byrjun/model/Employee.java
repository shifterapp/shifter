package byrjun.model;

/**
 * The class holds information about an employee in the system.
 * @author Hópur 2
 * @date September 2017
 */

public class Employee {
	private String name;
	private String email;
	private String type;
	private String size;
	
	public Employee(String name, String email, String type, String size) {
		this.name = name;
		this.email = email;
		this.type = type;
		this.size = size;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}

}
