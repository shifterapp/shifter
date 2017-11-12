package byrjun.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import byrjun.model.Employee;
import byrjun.model.ShirtSizes;
import byrjun.services.EmployeeService;

/**
 * Controller that controls what happens when user or the interface sends
 * commands which concerns the user registration.
 * 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017 HBV 501G Hugbúnaðarverkefni Háskóli Íslands
 */

@Controller
@RequestMapping("/") // Request Mapping. The Path begins with / for every method calls.
public class EmployeeController {

	// Connection to a service class for the shifter app.
	@Autowired
	EmployeeService employeeService;

	/**
	 * Asks for input values.
	 * 
	 * @return /employeeRegistration view.
	 */
	@RequestMapping("/")
	public String requestInputValues(Model model) {
		Employee e = new Employee();
		model.addAttribute("employee", e);
		return "employeeRegistration";
	}

	/**
	 * Takes in information about the employee and displays it.
	 * 
	 * @param name
	 *            name of the employee
	 * @param email
	 *            the employee's email
	 * @param employeeType
	 *            the role of the employee on the event.
	 * @param size
	 *            the employee's t shirt size
	 * @param model
	 *            model for "communication" to the view
	 * @return returns confirmation page if the input values are on the correct form
	 *         but the registration page with error message otherwise.
	 */
	@RequestMapping(value = "/employeeInfo", method = RequestMethod.POST)
	public String employeeInfo(@Valid @ModelAttribute(name = "employee") Employee e, BindingResult bindingResult,
			ModelMap model) throws ParseException {
		if (!bindingResult.hasErrors() && employeeService.nameOnCorrectForm(e.getName())
				&& employeeService.emailOnCorrectForm(e.getEmail())) {
			model.addAttribute("employee", e);
			employeeService.addEmployee(e);
			return "/employeeConfirmation";
		} else {
			String errorMessage = "errorMessage";
			model.addAttribute("errorMessage", errorMessage);
			return "/employeeRegistration";
		}
	}

	/**
	 * Displays list of employees
	 * 
	 * @param model
	 *            model for "communication" to the view
	 * @return page with a list of employees
	 */
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public String employeeList(Model model) {
		LinkedList<Employee> employees;
		employees = (LinkedList<Employee>) employeeService.allEmployees();
		model.addAttribute("employees", employees);
		return "/allEmployees";
	}
	
	@RequestMapping(value = "/employeeSearch", method = RequestMethod.POST)
	public String employeeSearch( @RequestParam(value="searchString", required=false) String searchString, 
			ModelMap model) throws ParseException {
		LinkedList<Employee> employees;
		employees = employeeService.searchForEmployee(searchString,searchString,searchString);
		model.addAttribute("employees", employees);
		return "/allEmployees";
	}
	
	@RequestMapping(value = "/employeeShirts", method = RequestMethod.GET)
	public String employeeShirts(Model model){
		LinkedList<ShirtSizes> shirtSizes;
		shirtSizes = employeeService.sizeCounts();
		model.addAttribute("shirtSizes", shirtSizes);		
		return "/shirtSizes";
	}

}
