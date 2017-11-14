package byrjun.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The class holds information about all employees in the app.
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

import byrjun.model.Employee;
import byrjun.model.Shift;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	/**
	 * Returns all employees in the app.
	 * @return list of all employees.
	 */
	LinkedList<Employee> findAll();
	
	/**
	 * Adds an eployee to the database.
	 * @param Employee
	 */
	Employee save (Employee employee);
	
	/**
	 * Use findEmployee instead
	 */
	LinkedList<Employee> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrTypeContainingIgnoreCase(String name,  String email, String type);
	
	/**
	 * Finds employee by name and returns that employees.
	 * @param nafn
	 * @return list of employees with that name. 
	 */
	default LinkedList<Employee> findEmployee(String name, String email, String type){
	return findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrTypeContainingIgnoreCase(name,  email,  type);
	}
	
	
	/**
	 * Returns employee with that id
	 * @param id of employee
	 * @return employee with that id
	 */
	Employee findById(Long id);
	
	/**
	 * Orders by name in ascending order
	 */
	LinkedList<Employee> findAllByOrderByNameAsc();
	
	/**
	 * Orders by type in ascending order
	 */
	LinkedList<Employee> findAllByOrderByTypeAsc();
	
	/**
	 * Orders by t-shirt in ascending order
	 */
	LinkedList<Employee> findAllByOrderBySizeAsc();
	
	/**
	 * Orders by date in ascending order
	 */
	LinkedList<Employee> findAllByOrderByDateAsc();
	
	/**
	 * Returns true if employee with given id exists.
	 * @param id of employee
	 * @return boolean value which states if employee with that id exists or not.
	 */
	boolean exists(Long id);
	
	/**
	 * Returns the number of employees of a certain size
	 * @param size of t-shirt for employees
	 * @return the number of employees of that size
	 */
	int countBySize(String size);


}
