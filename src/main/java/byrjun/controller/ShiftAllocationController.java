package byrjun.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import byrjun.model.ShiftAllocation;
import byrjun.services.ShiftAllocationService;
import byrjun.services.ValidationService;

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
	ValidationService validationService;
	
    /**
     * Asks for input values.
     * @return /shiftRgistration view.
     */
    @RequestMapping("/shiftAllocationPage")
    public String requestInputValues() {
    	return "/shiftAllocationPage";
    }
    
    @RequestMapping(value="/shiftAllocationAction", method=RequestMethod.POST)
    public String randomizeShifts(
    		@RequestParam(value="empId", required=false) String empId,
    		@RequestParam(value="shiftId", required=false) String shiftId,
    		ModelMap model) throws ParseException{
    	int empIdInt = Integer.parseInt(empId);
    	int shiftIdInt = Integer.parseInt(shiftId);
    	
    	if(shiftAllocationService.checkIfEmployeeExcists(empIdInt) && shiftAllocationService.checkIfShiftExcists(shiftIdInt)) {
    		ShiftAllocation sa = new ShiftAllocation(empIdInt ,shiftIdInt);
    		model.addAttribute("shiftAllocation", sa);
    		shiftAllocationService.addShiftAllocation(sa);
    	
    	return "/shiftAllocationList";
    	}
    	else{
    		return "/shiftAllocationList";
    	}
    }
	

}

