package byrjun.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import byrjun.model.Employee;

/**
 * Implementation for the EmployeeRepository class. 
 * @author Hópur 2: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

@Repository
public class EmployeeRepositoryImp  implements EmployeeRepository{

	//List of employees
	private final List<Employee> employees;
	
	public EmployeeRepositoryImp() {
		this.employees = new ArrayList<Employee>();
	}
	
	@Override
	public List<Employee> getAll(){
		return employees;
	}

	@Override
	public void add (Employee employee) {
		employees.add(employee);
	}
	
}
