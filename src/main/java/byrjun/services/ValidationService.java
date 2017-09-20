package byrjun.services;

import java.util.List;

import byrjun.model.Employee;

/**
 * 
 * Service class that includes methods that do validation checks.
 * @author Hópur 2 
 * @date september 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
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
	 * Checks if the user does add date of birth
	 * @param date
	 * @retun
	 */
	public boolean dateNotEmpty(String date);
	
	/**
	 * Returns error message depended on witch input values are on the
	 * incorrect form.
	 * @return Error message string.
	 */
	public String getErrorMessage(String name,String email,String date);
	
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
