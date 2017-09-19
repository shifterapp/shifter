package byrjun.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import byrjun.model.Employee;
import byrjun.repository.EmployeeRepository;
import byrjun.services.ValidationService;

/**
 * Byrjunarcontroller sem stýrir hvað er gert þegar notandi eða viðmót
 * setur inn skipun 
 */
 
@Controller
@RequestMapping("/") // Request Mapping. The Path begins with / for every method calls. 
public class DemoController {
	
	

	//Connection to a service class for the shifter app. 
	@Autowired
	ValidationService validationService;
	
	//Connection to a collection of employees.
	@Autowired
    EmployeeRepository employeeRep;
	
    /*
     * Asks for input values.
     * @return
     */
    @RequestMapping("/")
    public String requestInputValues() {
    	return "/registration";
    }
   
    /*
     * Takes in information about the employee and displays it.
     * @param name name of the employee
     * @param email the employees email
     * @param employeeType the type of the employee
     * @param size the employees t shirt size
     * @param model 
     * @return returns confirmation page if the input values are on the correct form but error message
     * otherwise.
     */
    @RequestMapping(value="/employeeInfo", method=RequestMethod.POST)
    public String employeeInfo(
    		@RequestParam(value="name", required=false) String name, 
    		@RequestParam(value="date", required=false) String date, 
    		@RequestParam(value="email", required=false) String email, 
    		@RequestParam(value="employeeType", required=false) String employeeType, 
    		@RequestParam(value="size", required=false) String size, 
    		ModelMap model) throws ParseException{
    
    	if(validationService.nameOnCorrectForm(name) && validationService.emailOnCorrectForm(email)) {
    		Employee e = new Employee(name ,date, email, employeeType, size);
    		model.addAttribute("employee", e);
    		employeeRep.add(e);
    		return "/confirmation";
    	} else if (!validationService.nameOnCorrectForm(name)) {
    		String errorMessage = "Vinsamlegast tilgreindu fullt nafn.";
    		model.addAttribute("errorMessage", errorMessage);
    		return "/registration";
    	} else if (!validationService.emailOnCorrectForm(email)) {
    		String errorMessage = "Email á röngu formi.";
    		model.addAttribute("errorMessage", errorMessage);
    		return "/registration";
    	} else {
    		model.addAttribute("name", name);
    		return "/errorMessage";
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
    	list = (ArrayList<Employee>) employeeRep.getAll();
    	model.addAttribute("employees", list);
    	return "/allEmployees";
    }

}
