package byrjun.repository;

import java.util.List;



/**
 * The class holds information about all employees in the app.
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

import byrjun.model.Employee;

public interface EmployeeRepository {
	
	/**
	 * Returns all employees in the app.
	 * @return list of all employees.
	 */
	List <Employee> getAll();
	
	/**
	 * Adds an employee to the app.
	 * @param employee
	 */
	void add(Employee employee);

}
