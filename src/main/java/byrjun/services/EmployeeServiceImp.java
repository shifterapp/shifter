package byrjun.services;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.Employee;
import byrjun.model.ShirtSizes;
import byrjun.repository.EmployeeRepository;

/**
 * Implementation for the ValidationService class.
 * 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017 HBV 501G Hugbúnaðarverkefni Háskóli Íslands
 */

@Service
public class EmployeeServiceImp implements EmployeeService {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private int fjoldiNafna = 2;

	// Connecton to the list of employees.
	@Autowired
	EmployeeRepository employeeRep;

	@Override
	public boolean nameOnCorrectForm(String name) {
		String[] splittedName = name.split("\\s+");
		if (splittedName.length < fjoldiNafna) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean emailOnCorrectForm(String email) {
		Pattern p = Pattern.compile(EMAIL_PATTERN);
		Matcher m = p.matcher(email);
		if (!m.find()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean dateNotEmpty(String date) {
		if (date.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String getEmployeeErrorMessage(String name, String email, String date) {
		String errorMessage = "";
		if (!nameOnCorrectForm(name)) {
			errorMessage += "Vinsamlegast skráðu fullt nafn. <br/>";
		}
		if (!emailOnCorrectForm(email)) {
			errorMessage += "Athugaðu að netfangið sé á réttu formi. <br/>";
		}
		if (!dateNotEmpty(date)) {
			errorMessage += "Vinsamlegast fylltu inn fæðingardag. <br/>";
		}
		return errorMessage;
	}

	@Override
	public void addEmployee(Employee e) {
		if(!checkIfIdentical(e)) {
			employeeRep.save(e);			
		}
	}

	@Override
	public boolean checkIfIdentical(Employee e) {
		String name = e.getName();
		String email = e.getEmail();
		String type = e.getType();	
		
		Employee ee = employeeRep.findByNameAndEmailAndType(name, email, type);
		if(ee == null){
			return false;
		}
		
		if (name.equals(ee.getName()) && email.equals(ee.getEmail()) && type.equals(e.getType())) {
			return true;
		}
		return false;
	}

	@Override
	public LinkedList<Employee> allEmployees() {
		return employeeRep.findAll();

	}

	@Override
	public LinkedList<Employee> allEmployeesAscName() {
		return employeeRep.findAllByOrderByNameAsc();
	}

	@Override
	public LinkedList<Employee> allEmployeesAscType() {
		return employeeRep.findAllByOrderByTypeAsc();
	}

	@Override
	public LinkedList<Employee> allEmployeesAscSize() {
		return employeeRep.findAllByOrderBySizeAsc();
	}

	@Override
	public LinkedList<Employee> allEmployeesAscDate() {
		return employeeRep.findAllByOrderByDateAsc();
	}

	@Override
	public Employee getEmpById(Long empId) {
		return employeeRep.findById(empId);
	}

	@Override
	public boolean checkIfEmpExists(Long empId) {
		return employeeRep.exists(empId);
	}

	@Override
	public LinkedList<Employee> searchForEmployee(String name, String email, String type) {
		LinkedList<Employee> employees = employeeRep
				.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrTypeContainingIgnoreCase(name, email, type);
		return employees;
	}

	@Override
	public LinkedList<ShirtSizes> sizeCounts() {
		LinkedList<ShirtSizes> shirtSizes = new LinkedList<ShirtSizes>();
		int[] sizeCounts = new int[7];
		String[] sizes = { "XS", "S", "M", "L", "XL", "XXL", "XXXL" };
		for (int i = 0; i < sizeCounts.length; i++) {
			sizeCounts[i] = employeeRep.countBySize(sizes[i]);
		}
		ShirtSizes XSSizes = new ShirtSizes("XS", sizeCounts[0]);
		ShirtSizes SSizes = new ShirtSizes("S", sizeCounts[1]);
		ShirtSizes MSizes = new ShirtSizes("M", sizeCounts[2]);
		ShirtSizes LSizes = new ShirtSizes("L", sizeCounts[3]);
		ShirtSizes XLSizes = new ShirtSizes("XL", sizeCounts[4]);
		ShirtSizes XXLSizes = new ShirtSizes("XXL", sizeCounts[5]);
		ShirtSizes XXXLSizes = new ShirtSizes("XXXL", sizeCounts[6]);

		shirtSizes.add(XSSizes);
		shirtSizes.add(SSizes);
		shirtSizes.add(MSizes);
		shirtSizes.add(LSizes);
		shirtSizes.add(XLSizes);
		shirtSizes.add(XXLSizes);
		shirtSizes.add(XXXLSizes);

		return shirtSizes;
	}
}
