package byrjun.services;

import java.util.LinkedList;
import java.util.List;

import byrjun.model.Employee;
import byrjun.model.ShirtSizes;

/**
 * 
 * Service class that includes methods that do validation checks.
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date september 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

public interface EmployeeService {
	
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
	 * @retun returns true if date is not empty.
	 */
	public boolean dateNotEmpty(String date);
	
	/**
	 * Returns error message depended on witch input values are on the
	 * incorrect form.
	 * @return Error message string.
	 */
	public String getEmployeeErrorMessage(String name,String email,String date);

	/**
	 * Adds an employee to the repository
	 * @param Employee
	 */
	public void addEmployee(Employee e);
	
	/**
	 * Returns all employees in the employeeRepository.
	 * @returns list of employees in the employeeRepository.
	 */
	public LinkedList<Employee> allEmployees();
	
	/**
	 * Returns list of employees that has searchString somewhere in the information about them
	 * @param searchString the string that the user is searching by
	 * @return list of employees corresponded to that searchString
	 */
	public LinkedList<Employee> searchForEmployee(String name, String email, String type);
	
	/**
	 * Returns employee with the id empId
	 * @param empId the id of the employee.
	 * @returns the employee with the id employeeId.
	 */
	public Employee getEmpById(Long empId);
	
	/**
	 * Returns true if employee with given id exists.
	 * @param id of employee
	 * @return boolean value which states if employee with that id exists or not.
	 */
	public boolean checkIfEmpExists(Long empId);
	
	/**
	 * Returns
	 * @return
	 */
	public LinkedList<ShirtSizes> sizeCounts();
		
	

}
