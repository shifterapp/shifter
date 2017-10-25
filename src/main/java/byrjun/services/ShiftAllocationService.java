package byrjun.services;

import byrjun.model.ShiftAllocation;

public interface ShiftAllocationService {
	
	/**
	 * Adds a shiftAllocation to the repository
	 * @param ShiftAllocation
	 */
	public void addShiftAllocation(ShiftAllocation sa);
	
	/**
	 * Checks if the name is on the correct form.
	 * @param name
	 * @return returns true if the name is on the correct form.
	 */
	public boolean checkIfShiftIsFull(int id);
	
	/**
	 * Checks if that employee is allready on that shift.
	 * @param id of employee
	 * @param id of shift
	 * @return returns true if that employee is not allready on the shift.
	 */
	public boolean checkIfShiftAllocationExists(int empId, int shiftId);

	/**
	 * Returns error message depended on if it is employee or shift that doesn't exists.
	 * @return Error message string.
	 */
	public String getShiftAllocationErrorMessage(Long empId, Long shiftId);


}
