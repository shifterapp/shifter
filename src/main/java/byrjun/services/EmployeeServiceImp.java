package byrjun.services;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.Employee;
import byrjun.repository.EmployeeRepository;

/**
 * Implementation for the ValidationService class. 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private static final String EMAIL_PATTERN =
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
		 Pattern p = Pattern.compile(EMAIL_PATTERN);
	     Matcher m = p.matcher(email);
	     if(!m.find()) {
	    	 return false;
	     }
	     else {
	    	 return true;
	     }
	}
	
	@Override
	public boolean dateNotEmpty(String date){
		if(date.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override 
	public String getEmployeeErrorMessage(String name,String email,String date) {
	String errorMessage = "";
	if(!nameOnCorrectForm(name)) {
		errorMessage += "Vinsamlegast skráðu fullt nafn. <br/>";
	}
	if(!emailOnCorrectForm(email)) {
		errorMessage += "Athugaðu að netfangið sé á réttu formi. <br/>";
	}
	if(!dateNotEmpty(date)) {
		errorMessage += "Vinsamlegast fylltu inn fæðingardag. <br/>";
	}
	return errorMessage;
	}
	
	@Override
	public void addEmployee (Employee e) {
		employeeRep.save(e);
	}

	@Override
	public List<Employee> allEmployees() {
		return employeeRep.findAll();
	}
	
	@Override 
	public Employee getEmpById(Long empId) {
		return employeeRep.findById(empId);
	}
}
