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

import byrjun.model.Shift;
import byrjun.services.ShiftService;

/**
 * Controller that controls what happens when user or the interface sends commands which concerns
 * the shift registration. 
 * 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */
 
@Controller
@RequestMapping("/") // Request Mapping. The Path begins with / for every method calls. 
public class ShiftController {
	
	//Connection to a service class for the shifter app. 
	@Autowired
	ShiftService shiftService;
	
    /**
     * Asks for input values.
     * @return /shiftRgistration view.
     */
    @RequestMapping("/shiftRegistration")
    public String requestInputValues() {
    	return "/shiftRegistration";
    }
   
    /**
     * Takes in information about the shift and displays it.
     * @param  title of the shift
     * @param date the date of the shift
     * @param beginTime when the shift starts.
     * @param endTime when the shift ends.
     * @param limit the max number of employees on the shift.
     * @param type the type of the shift.
     * @return returns confirmation page if the input values are on the correct form but the registration page with
     * error message otherwise.
     */
    @RequestMapping(value="/shiftInfo", method=RequestMethod.POST)
    public String shiftInfo(
    		@RequestParam(value="title", required=false) String title,
    		@RequestParam(value="shiftType", required=false) String shiftType,
    		@RequestParam(value="shiftDate", required=false) String shiftDate, 
    		@RequestParam(value="beginTime", required=false) String beginTime, 
    		@RequestParam(value="endTime", required=false) String endTime,
    		@RequestParam(value="howMany", required=false) String howMany,
    		ModelMap model) throws ParseException{
    
    if(shiftService.dateNotEmpty(shiftDate)  && shiftService.beginTimeNotEmpty(beginTime) && shiftService.endTimeNotEmpty(endTime) && shiftService.timeCorrect(beginTime,endTime) && shiftService.shiftTitleNotEmpty(title) && shiftService.howManyNotEmpty(howMany)) {
    		Shift s = new Shift(title, shiftType, shiftDate, beginTime, endTime, howMany);
    		model.addAttribute("shift", s);
    		shiftService.addShift(s);
    		return "/shiftConfirmation";
    }
    else {
    	String errorMessage = shiftService.getShiftErrorMessage(shiftDate,beginTime,endTime,title,howMany);
		model.addAttribute("errorMessage", errorMessage); 
		return "/shiftRegistration";
    }
    }
    
    /**
     * Displays list of shifts
     * @param model model for "communication" to the view
     * @return page with a list of employees
     */
    @RequestMapping(value = "/shiftList", method = RequestMethod.GET)
    public String employeeList(Model model) {
    	ArrayList<Shift> list;
    	list = (ArrayList<Shift>) shiftService.allShifts();
    	model.addAttribute("shifts", list);
    	return "/allShifts";
    }

}
