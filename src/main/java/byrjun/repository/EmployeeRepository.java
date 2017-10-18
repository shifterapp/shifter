package byrjun.repository;

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
	List<Employee> findAll();
	
	/**
	 * Adds an eployee to the database.
	 * @param Employee
	 */
	Employee save (Employee employee);
	
	/**
	 * Finds employee by name and returns that employees.
	 * @param nafn
	 * @return list of employees with that name. 
	 */
	List<Employee> findByName(String nafn);
	
//	Employee findOne(Long id);
	
	Employee findById(Long id);
	
//	List<Employee> findByEmp_id(Long empId);

}
