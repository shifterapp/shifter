package byrjun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.Employee;
import byrjun.repository.EmployeeRepository;

@Service
public class ValidationServiceImp implements ValidationService {
	
	// Connecton to the list of employees.
	@Autowired
	EmployeeRepository employeeRep;
	
	@Override
	public boolean nameOnCorrectForm(String name) {
		return true;
	}
	@Override
	public boolean emailOnCorrectForm(String name) {
		return true;
	}
	
	@Override
	public void addEmployee (Employee e) {
		employeeRep.add(e);
	}

	@Override
	public List<Employee> allEmployees() {
		return employeeRep.getAll();
	}
	
}
