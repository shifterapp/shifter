package byrjun.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
    @RequestMapping("/shiftAllocationPage")
    public String requestInputValues() {
    	return "/shiftAllocationPage";
    }
    
    @RequestMapping(value="/shiftAllocationAction", method=RequestMethod.POST)
    public String addEmpToShift(
    		@RequestParam(value="empId", required=false) String empId,
    		@RequestParam(value="shiftId", required=false) String shiftId,
    		ModelMap model) throws ParseException{
    	int empIdInt = Integer.parseInt(empId);
    	int shiftIdInt = Integer.parseInt(shiftId);
    	
    	if(shiftAllocationService.checkIfEmployeeExcists(empIdInt) && shiftAllocationService.checkIfShiftExcists(shiftIdInt)) {
    		ShiftAllocation sa = new ShiftAllocation(empIdInt ,shiftIdInt);
    		model.addAttribute("shiftAllocation", sa);
    		Employee e = employeeService.getEmpById(Long.valueOf(empIdInt));
    		model.addAttribute("employee", e);
    		Shift s = shiftService.getShiftById(Long.valueOf(shiftIdInt));
    		model.addAttribute("shift", s);
    		shiftAllocationService.addShiftAllocation(sa);
    		model.addAttribute("empIdInt", empIdInt);
    		model.addAttribute("shiftIdInt", shiftIdInt);
    	
    	return "/shiftAllocationConfirmation";
    	}
    	else{
    		return "/shiftAllocationConfirmation";
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

