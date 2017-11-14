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
import byrjun.model.Shift;
import byrjun.services.ShiftService;

/**
 * Controller that controls what happens when user or the interface sends
 * commands which concerns the shift registration.
 * 
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date September 2017 HBV 501G Hugbúnaðarverkefni Háskóli Íslands
 */

@Controller
@RequestMapping("/") // Request Mapping. The Path begins with / for every method calls.
public class ShiftController {

	// Connection to a service class for the shifter app.
	@Autowired
	ShiftService shiftService;

	/**
	 * Asks for input values.
	 * 
	 * @return /shiftRgistration view.
	 */
	@RequestMapping("/shiftRegistration")
	public String requestInputValues(Model model) {
		Shift s = new Shift();
		model.addAttribute("shift", s);
		return "/shiftRegistration";
	}

	/**
	 * Takes in information about the shift and displays it.
	 * 
	 * @param title
	 *            of the shift
	 * @param date
	 *            the date of the shift
	 * @param beginTime
	 *            when the shift starts.
	 * @param endTime
	 *            when the shift ends.
	 * @param limit
	 *            the max number of employees on the shift.
	 * @param type
	 *            the type of the shift.
	 * @return returns confirmation page if the input values are on the correct form
	 *         but the registration page with error message otherwise.
	 */
	@RequestMapping(value = "/shiftInfo", method = RequestMethod.POST)
	public String shiftInfo(@Valid @ModelAttribute(name = "shift") Shift s, BindingResult bindingResult, ModelMap model)
			throws ParseException {
		System.out.println("VILLUR VILLI VILL" + bindingResult.toString());
		if (!bindingResult.hasErrors()) {
			model.addAttribute("shift", s);
			shiftService.addShift(s);
			return "/shiftConfirmation";
		} else {
			String errorMessage = "errorMessage";
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
		LinkedList<Shift> list;
		list = (LinkedList<Shift>) shiftService.allShifts();
		model.addAttribute("shifts", list);
		return "/allShifts";
	}
	
	/**
	 * Searches for shifts with the searchString in its title or type
	 * @param searchString
	 * @param model
	 * @return the shifts where the type or title includes the searchstring
	 * @throws ParseException
	 */
	@RequestMapping(value = "/shiftSearch", method = RequestMethod.POST)
	public String shiftSearch( @RequestParam(value="searchString", required=false) String searchString, 
			ModelMap model) throws ParseException {
		LinkedList<Shift> shifts;
		shifts = shiftService.searchForShift(searchString,searchString);
		model.addAttribute("shifts", shifts);
		return "/allShifts";
	}
	
	@RequestMapping(value = "/shiftSort",params = "Titli", method = RequestMethod.GET)
	public String shiftSortTitle(Model model) {
		LinkedList<Shift> list;
		list = (LinkedList<Shift>) shiftService.allShiftsAscTitle();
		model.addAttribute("shifts", list);
		return "/allShifts";
	}
	@RequestMapping(value = "/shiftSort",params = "Tegund", method = RequestMethod.GET)
	public String shiftSortType(Model model) {
		LinkedList<Shift> list;
		list = (LinkedList<Shift>) shiftService.allShiftsAscType();
		model.addAttribute("shifts", list);
		return "/allShifts";
	}
	@RequestMapping(value = "/shiftSort",params = "Dagsetningu", method = RequestMethod.GET)
	public String shiftSortDate(Model model) {
		LinkedList<Shift> list;
		list = (LinkedList<Shift>) shiftService.allShiftsAscDate();
		model.addAttribute("shifts", list);
		return "/allShifts";
	}
	@RequestMapping(value = "/shiftSort",params = "Upphafstíma", method = RequestMethod.GET)
	public String shiftSortBegniTime(Model model) {
		LinkedList<Shift> list;
		list = (LinkedList<Shift>) shiftService.allShiftsAscBegintime();
		model.addAttribute("shifts", list);
		return "/allShifts";
	}
	

}
