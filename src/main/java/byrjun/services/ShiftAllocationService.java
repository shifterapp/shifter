package byrjun.services;

import byrjun.model.ShiftAllocation;

public interface ShiftAllocationService {
	
	/**
	 * Adds a shiftAllocation to the repository
	 * @param ShiftAllocation
	 */
	public void addShiftAllocation(ShiftAllocation sa);
	
	/**
	 * Checks if a employee with that id excists
	 */
	public boolean checkIfEmployeeExcists(int id);
	
	/**
	 * Checks if a shift with that id excists
	 */
	public boolean checkIfShiftExcists(int id);
	
	/**
	 * Checks if the name is on the correct form.
	 * @param name
	 * @return returns true if the name is on the correct form.
	 */
	public boolean checkIfShiftIsFull(int id);


}
