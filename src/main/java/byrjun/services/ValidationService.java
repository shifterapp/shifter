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

public interface ValidationService {
	
	/**
	 * Checks if the name is on the correct form.
	 * @param name
	 * @return returns true if the name is on the correct form.
	 */
	public boolean nameOnCorrectForm(String name);
	
	/**
	 * Checks if email is on the correct form.
	 * @param email
	 * @return returns true if the email is on correct form.
	 */
	public boolean emailOnCorrectForm(String email);
	
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
	public String getEmployeeErrorMessage(String name,String email,String date);
	
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
	 * Adds an employee to the repository
	 * @param Employee
	 */
	public void addEmployee(Employee e);
	
	/**
	 * Returns all employees in the employeeRepository.
	 * @returns list of employees in the employeeRepository.
	 */
	public List<Employee> allEmployees();
	
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

}
