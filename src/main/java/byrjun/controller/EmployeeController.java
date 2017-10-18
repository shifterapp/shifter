package byrjun.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import byrjun.model.Employee;
import byrjun.services.EmployeeService;

/**
 * Controller that controls what happens when user or the interface sends commands which concerns
 * the user registration. 
 * 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */
 
@Controller
@RequestMapping("/") // Request Mapping. The Path begins with / for every method calls. 
public class EmployeeController {
	
	//Connection to a service class for the shifter app. 
	@Autowired
	EmployeeService employeeService;
	
    /**
     * Asks for input values.
     * @return /employeeRegistration view.
     */
    @RequestMapping("/")
    public String requestInputValues() {
    	return "/employeeRegistration";
    }
   
    /**
     * Takes in information about the employee and displays it.
     * @param name name of the employee
     * @param email the employee's email
     * @param employeeType the role of the employee on the event.
     * @param size the employee's t shirt size
     * @param model model for "communication" to the view
     * @return returns confirmation page if the input values are on the correct form but the registration page with
     * error message otherwise.
     */
    @RequestMapping(value="/employeeInfo", method=RequestMethod.POST)
    public String employeeInfo(
    		@RequestParam(value="name", required=false) String name, 
    		@RequestParam(value="date", required=false) String date, 
    		@RequestParam(value="email", required=false) String email, 
    		@RequestParam(value="employeeType", required=false) String employeeType, 
    		@RequestParam(value="size", required=false) String size, 
    		ModelMap model) throws ParseException{
    
    	if(employeeService.nameOnCorrectForm(name) && employeeService.emailOnCorrectForm(email) && employeeService.dateNotEmpty(date)) {
    		Employee e = new Employee(name ,date, email, employeeType, size);
    		model.addAttribute("employee", e);
    		employeeService.addEmployee(e);
    		return "/confirmation";
    	}  else {
    		String errorMessage = employeeService.getEmployeeErrorMessage(name, email, date);
    		model.addAttribute("errorMessage", errorMessage); 
    		return "/employeeRegistration";
    	}
    }
    
    /**
     * Displays list of employees
     * @param model model for "communication" to the view
     * @return page with a list of employees
     */
    @RequestMapping(value = "/employeeList", method = RequestMethod.GET)
    public String employeeList(Model model) {
    	ArrayList<Employee> list;
    	list = (ArrayList<Employee>) employeeService.allEmployees();
    	model.addAttribute("employees", list);
    	return "/allEmployees";
    }

}
