package byrjun.services;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import byrjun.model.Employee;
import byrjun.model.Shift;
import byrjun.repository.EmployeeRepository;
import byrjun.repository.ShiftRepository;

/**
 * Implementation for the ValidationService class. 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

@Service
public class ValidationServiceImp implements ValidationService {
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	// Connecton to the list of employees.
	@Autowired
	EmployeeRepository employeeRep;
	// Connecton to the list of shifts
	@Autowired
	ShiftRepository shiftRep;
	
	@Override
	public boolean nameOnCorrectForm(String name) {
		String[] splittedName = name.split("\\s+");
		if(splittedName.length<2) {
			return false;
		}
		else {
			return true;}
	}
	
	//Test commit
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
	public String getShiftErrorMessage(String date,String beginTime,String endTime,String shiftTitle,String howMany) {
	String errorMessage = "";
	if(!dateNotEmpty(date)) {
		errorMessage += "Vinsamlegast fylltu inn dagsetningu vaktarinnar. <br/>";
	}
	
	if(!beginTimeNotEmpty(beginTime)){
		errorMessage += "Vinsamlegast fylltu inn upphafstíma vaktarinnar. <br/>";
	}
	if(!endTimeNotEmpty(endTime)){
		errorMessage += "Vinsamlegast fylltu inn endatíma vaktarinnar. <br/>";
	}
	if(beginTimeNotEmpty(beginTime) && endTimeNotEmpty(endTime)){
		if(!timeCorrect(beginTime,endTime)){
			errorMessage += "Athugaðu að vakt getur ekki endað áður en hún hefst. <br/>";
		}
	}
	if(!shiftTitleNotEmpty(shiftTitle)){
		errorMessage += "Vinsamlegast settu titil á vaktina. <br/>";
		
	}
	if(!howManyNotEmpty(howMany)){
		errorMessage += "Vinsamlegast settu fjölda starfsmanna á vaktina <br/>";
	}
	return errorMessage;
	}
	
	@Override
	public boolean timeCorrect(String beginTime, String endTime){
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime beginTimeObject = LocalTime.parse(beginTime,timeFormatter);
		LocalTime endTimeObject = LocalTime.parse(endTime,timeFormatter);
		if(beginTimeObject.isBefore(endTimeObject)){
			return true;
		}
			return false;
	}
	
	@Override
	public boolean beginTimeNotEmpty(String beginTime){
		if(beginTime== ""){
			return false;
		}
		return true;
	}
	
	@Override
	public boolean endTimeNotEmpty(String endTime){
		if(endTime == ""){
			return false;
		}
		return true;
	}
	@Override
	public boolean shiftTitleNotEmpty(String shiftTitle){
		if(shiftTitle == ""){
			return false;
		}
		return true;
		
	}
	@Override
	public boolean howManyNotEmpty(String howMany){
		if(howMany ==""){
			return false;
		}
		return true;
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
	public void addShift(Shift s) {
		shiftRep.save(s);
		
	}

	@Override
	public List<Shift> allShifts() {
		return shiftRep.findAll();
	}
	
}
