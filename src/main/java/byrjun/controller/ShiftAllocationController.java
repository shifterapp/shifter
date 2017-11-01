package byrjun.controller;

import java.text.ParseException;

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

import byrjun.model.ShiftAllocation;
import byrjun.model.Employee;
import byrjun.model.Shift;
import byrjun.services.EmployeeService;
import byrjun.services.ShiftAllocationService;
import byrjun.services.ShiftService;

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
public class ShiftAllocationController {
	
	//Connection to a service class for the shifter app. 
	@Autowired
	ShiftAllocationService shiftAllocationService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	ShiftService shiftService;
	
    /**
     * Asks for input values.
     * @return /shiftRgistration view.
     */
    @RequestMapping("/shiftAllocation")
    public String requestInputValues(Model model) {
    ShiftAllocation sa = new ShiftAllocation();
	model.addAttribute("shiftAllocation", sa);
    	return "/shiftAllocation";
    }
    
    @RequestMapping(value="/shiftAllocationInfo", method=RequestMethod.POST)
    public String addEmpToShift(
    		@Valid @ModelAttribute(name = "shiftAllocation") ShiftAllocation sa, BindingResult bindingResult, ModelMap model) throws ParseException{
     	System.out.println("is Null????" + sa.getEmpId());
    	System.out.println("has errors????" + bindingResult.toString());
    	if(!bindingResult.hasErrors() && employeeService.checkIfEmpExists(Long.valueOf(sa.getEmpId())) && shiftService.checkIfShiftExists(Long.valueOf(sa.getShiftId()))) {
    		model.addAttribute("shiftAllocation", sa);
    		Employee e = employeeService.getEmpById(Long.valueOf(sa.getEmpId()));
    		model.addAttribute("employee", e);
    		Shift s = shiftService.getShiftById(Long.valueOf(sa.getShiftId()));
    		model.addAttribute("shift", s);
    		shiftAllocationService.addShiftAllocation(sa);
    	
    	return "/shiftAllocationConfirmation";
    	}
    	else{
//    		String errorMessage = shiftAllocationService.getShiftAllocationErrorMessage(Long.valueOf(sa.getEmpId()), Long.valueOf(sa.getShiftId()));
    		String errorMessage = "errorMessage";
    		model.addAttribute("errorMessage", errorMessage); 
    		return "/shiftAllocation";
    	}
    }
    
    
    /**
     * Displays list of employees on each shift.
     * @param model model for "communication" to the view
     * @return page with a list of employees on each shift.
     */
    @RequestMapping(value = "/shiftAllocationsView", method = RequestMethod.GET)
    public String shiftAllocationsView(Model model) {
    	return "/shiftAllocationList";
    }
	

}

