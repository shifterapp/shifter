package byrjun.services;

import java.util.List;

import byrjun.model.Employee;

/**
*@author Hópur 2 
*@date september 2017
*HBV 501G Hugbúnaðarverkefni
*Háskóli Íslands
*/

public interface ValidationService {
	
	/**
	 * Checks if the name is on the correct form.
	 * @param name
	 * @return returns true if the name is on the correct form.
	 */
	public boolean nameOnCorrectForm(String name);
	
	/**
	 * Checks if email is on the correct form.
	 * @param email
	 * @return returns true if the email is on correct form.
	 */
	public boolean emailOnCorrectForm(String email);
	
	/**
	 * Adds employee to the employeeRepository.
	 * @param Employee
	 */
	public void addEmployee(Employee e);
	
	/**
	 * Returns all employees in the employeeRepository.
	 * @returns all employees in the employeeRepository.
	 */
	public List<Employee> allEmployees();

}
