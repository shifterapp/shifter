package byrjun.services;

import java.time.LocalTime;
import java.util.List;

import byrjun.model.Employee;
import byrjun.model.Shift;

/**
 * 
 * Service class that includes methods that do validation checks.
 * @author Teymi 7: Arnar Már, Jón Ágúst, Markús Freyr og Sigrún Dís
 * @date september 2017
 * HBV 501G Hugbúnaðarverkefni
 * Háskóli Íslands
 */

public interface ShiftService {
	
	/**
	 * Checks if the user does add date of birth
	 * @param date
	 * @retun returns true if date is not empty.
	 */
	public boolean dateNotEmpty(String date);
	
	
	/**
	 * Returns error message depended on witch input values are on the
	 * incorrect form.
	 * @return Error message string.
	 */
	public String getShiftErrorMessage(String date,String beginTime,String endTime,String shiftTitle, String howMany);
	
	/**
	 * Checks if the shifts begins before it ends
	 * @param beginTime,endTime
	 * @return returns true if the shift begins 
	 */
	public boolean timeCorrect(String beginTime, String endTime);
	
	/**
	 * Checks if the shift has a valid start time
	 * @param beginTime
	 * @return returns true if a begin time of a shift is not empty
	 */
	public boolean beginTimeNotEmpty(String beginTime);
	
	/**
	 * Checks if the shift has a valid end time
	 * @param endTime
	 * @param returns true if the endTime of a shift is not empty
	 */
	public boolean endTimeNotEmpty(String endTime);
	
	/**
	 * Checks if the shift has a title
	 * @param shiftTitle
	 * @return returns true if the title of the shift is not empty
	 */
	public boolean shiftTitleNotEmpty(String shiftTitle);
	
	/**
	 * Checks if the shift has a number of employees
	 * @param howMany
	 * @return returns true if the shift has a number of employees
	 */	
	public boolean howManyNotEmpty(String howMany);
	
	/**
	 * Adds shift to the shiftRepository.
	 * @param Shift
	 */
	public void addShift(Shift s);
	
	/**
	 * Returns all shifts in the shiftRepository.
	 * @returns list of employees in the shiftRepository.
	 */
	public List<Shift> allShifts();
	
	/**
	 * Returns shift with the id shiftId
	 * @param shiftId the id of the shift.
	 * @returns the shift with the id shiftId.
	 */
	public Shift getShiftById(Long shiftId);
	

}
