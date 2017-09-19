package byrjun.services;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.Employee;
import byrjun.repository.EmployeeRepository;

@Service
public class ValidationServiceImp implements ValidationService {
	
	private static final String emailPattern =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	// Connecton to the list of employees.
	@Autowired
	EmployeeRepository employeeRep;
	
	@Override
	public boolean nameOnCorrectForm(String name) {
		String[] splittedName = name.split("\\s+");
		if(splittedName.length<2) {
			return false;
		}
		else {
			return true;}
	}
	@Override
	public boolean emailOnCorrectForm(String email) {
		 Pattern p = Pattern.compile(emailPattern);
	     Matcher m = p.matcher(email);
	     if(!m.find()) {
	    	 return false;
	     }
	     else {
	    	 return true;
	     }
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
