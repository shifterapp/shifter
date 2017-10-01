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
	
	List<Employee> findByName(String nafn);
	
	@Override
	Employee findOne(Long id);

}
